package ua.ivashchuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.ivashchuk.dao.UserRepository;
import ua.ivashchuk.domain.User;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepos;

    public UserService(UserRepository userRepos) {
        this.userRepos = userRepos;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepos.findByUsername(username);
    }

    public User findByEmail(String username){
        return userRepos.findByUsername(username);
    }
}
