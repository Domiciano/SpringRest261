package edu.co.icesi.introspringboot.controller;

import edu.co.icesi.introspringboot.entity.*;
import edu.co.icesi.introspringboot.entity.keys.RolePermissionId;
import edu.co.icesi.introspringboot.entity.keys.UserRoleId;
import edu.co.icesi.introspringboot.repository.PermissionRepository;
import edu.co.icesi.introspringboot.repository.RoleRepository;
import edu.co.icesi.introspringboot.repository.UserRepository;
import edu.co.icesi.introspringboot.service.RolePermissionService;
import edu.co.icesi.introspringboot.service.UserRoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final UserRoleService userRoleService;
    private final RolePermissionService rolePermissionService;

    public AdminController(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PermissionRepository permissionRepository,
                           UserRoleService userRoleService,
                           RolePermissionService rolePermissionService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.userRoleService = userRoleService;
        this.rolePermissionService = rolePermissionService;
    }

    // ─── USUARIOS ────────────────────────────────────────────────────────────

    @GetMapping("/users")
    @Transactional(readOnly = true)
    public String users(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/users";
    }

    @PostMapping("/users/{userId}/assign-role")
    public String assignRole(@PathVariable Integer userId, @RequestParam Integer roleId) {
        UserRoleId id = new UserRoleId();
        id.setUserId(userId);
        id.setRoleId(roleId);

        if (userRoleService.findById(id).isEmpty()) {
            UserRole userRole = new UserRole();
            userRole.setId(id);
            User user = new User();
            user.setId(userId);
            Role role = new Role();
            role.setId(roleId);
            userRole.setUser(user);
            userRole.setRole(role);
            userRoleService.save(userRole);
        }
        return "redirect:/admin/users";
    }

    @PostMapping("/users/{userId}/remove-role")
    public String removeRole(@PathVariable Integer userId, @RequestParam Integer roleId) {
        UserRoleId id = new UserRoleId();
        id.setUserId(userId);
        id.setRoleId(roleId);
        userRoleService.deleteById(id);
        return "redirect:/admin/users";
    }

    // ─── ROLES Y PERMISOS ────────────────────────────────────────────────────

    @GetMapping("/roles")
    @Transactional(readOnly = true)
    public String roles(Model model) {
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("permissions", permissionRepository.findAll());
        return "admin/roles";
    }

    @PostMapping("/roles/{roleId}/assign-permission")
    public String assignPermission(@PathVariable Integer roleId, @RequestParam Integer permissionId) {
        RolePermissionId id = new RolePermissionId();
        id.setRoleId(roleId);
        id.setPermissionId(permissionId);

        if (rolePermissionService.findById(id).isEmpty()) {
            RolePermission rp = new RolePermission();
            rp.setId(id);
            Role role = new Role();
            role.setId(roleId);
            Permission permission = new Permission();
            permission.setId(permissionId);
            rp.setRole(role);
            rp.setPermission(permission);
            rolePermissionService.save(rp);
        }
        return "redirect:/admin/roles";
    }

    @PostMapping("/roles/{roleId}/remove-permission")
    public String removePermission(@PathVariable Integer roleId, @RequestParam Integer permissionId) {
        RolePermissionId id = new RolePermissionId();
        id.setRoleId(roleId);
        id.setPermissionId(permissionId);
        rolePermissionService.deleteById(id);
        return "redirect:/admin/roles";
    }
}
