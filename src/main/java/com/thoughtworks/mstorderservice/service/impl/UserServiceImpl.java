package com.thoughtworks.mstorderservice.service.impl;

import com.thoughtworks.mstorderservice.Repository.UserRepository;
import com.thoughtworks.mstorderservice.configuration.security.JWTUser;
import com.thoughtworks.mstorderservice.entity.Privilege;
import com.thoughtworks.mstorderservice.entity.Role;
import com.thoughtworks.mstorderservice.entity.User;
import com.thoughtworks.mstorderservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username does not exist.");
        }
        Role role = user.getRole();
        return JWTUser.builder()
                .username(user.getName())
                .password(user.getPassword())
                .role(user.getRole().getSymbol().name())
                .privileges(role.getPrivileges().stream().map(Privilege::getSymbol).collect(toList()))
                .build();
    }
}
