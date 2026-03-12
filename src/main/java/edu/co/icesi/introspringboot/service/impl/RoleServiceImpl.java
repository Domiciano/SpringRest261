package edu.co.icesi.introspringboot.service.impl;

import edu.co.icesi.introspringboot.repository.RoleRepository;
import edu.co.icesi.introspringboot.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
