package com.example.springAuth.security;

import com.example.springAuth.persistance.entities.Person;
import com.example.springAuth.persistance.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    PersonRepo personRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Person> user = personRepository.findByUserName(userName);

        user.orElseThrow(()-> new UsernameNotFoundException("Not found : " + userName));
        Person person = user.get();

//        return user.map(MyUserDetails::new).get();
        return new MyUserDetails(person);
    }
}
