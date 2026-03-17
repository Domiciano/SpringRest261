package edu.co.icesi.introspringboot.service.impl;

import edu.co.icesi.introspringboot.repository.PermissionRepository;
import edu.co.icesi.introspringboot.service.PermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }
}
