package com.jpmc.mysecuredapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //IDEALLY CALL THE REPOSITORY METHODS
        MyUserDetails user = new MyUserDetails();
        if("joe".equalsIgnoreCase(username)) { //JUST FOR DEMO PURPOSE
            //Go to the db and find the record with the username
            //return the record
            user.setUsername(username);
            user.setId(1234L);
            user.setPassword(bCryptPasswordEncoder.encode("joe123"));
        } else {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }
}
