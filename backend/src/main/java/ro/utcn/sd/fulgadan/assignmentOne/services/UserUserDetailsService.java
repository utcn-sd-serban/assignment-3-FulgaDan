package ro.utcn.sd.fulgadan.assignmentOne.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.utcn.sd.fulgadan.assignmentOne.exceptions.NoSuchUserException;
import ro.utcn.sd.fulgadan.assignmentOne.models.User;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.RepositoryFactory;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserUserDetailsService implements UserDetailsService {
    private final RepositoryFactory repositoryFactory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repositoryFactory.createUserRepository().findByName(username).orElseThrow(() -> new NoSuchUserException());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
    @Transactional
    public User loadCurrentUser(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return repositoryFactory.createUserRepository().findByName(name).orElseThrow(() -> new NoSuchUserException());
    }
}
