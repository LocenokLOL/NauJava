package ru.ChernomortsevEgor.NauJava.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import ru.ChernomortsevEgor.NauJava.Enums.Role;
import ru.ChernomortsevEgor.NauJava.PojoClasses.User;
import ru.ChernomortsevEgor.NauJava.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PlatformTransactionManager transactionManager;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, PlatformTransactionManager transactionManager, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.transactionManager = transactionManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }
    @Override
    public boolean addUser(User user)
    {
        User repoCustomer = userRepository.findByUsername(user.getUsername());
        if (repoCustomer != null) {
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
        return true;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User customer = findByUsername(username);
        return new org.springframework.security.core.userdetails.User(customer.getUsername(), customer.getPassword(),
                mapRoleToAuthority(customer.getRole()));
    }
    private Collection<GrantedAuthority> mapRoleToAuthority(Role role) {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }
}
