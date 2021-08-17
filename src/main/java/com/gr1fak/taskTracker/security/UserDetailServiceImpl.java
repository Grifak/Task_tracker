package com.gr1fak.taskTracker.security;

import com.gr1fak.taskTracker.model.UserEntity;
import com.gr1fak.taskTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service()
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity entity = userRepository.findByLogin(login).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User with login %s not found", login))
        );
        return SecurityUser.fromUserEntity(entity);
    }


}
