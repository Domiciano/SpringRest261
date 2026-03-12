package edu.co.icesi.introspringboot.service.impl;

import edu.co.icesi.introspringboot.repository.UserRepository;
import edu.co.icesi.introspringboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
