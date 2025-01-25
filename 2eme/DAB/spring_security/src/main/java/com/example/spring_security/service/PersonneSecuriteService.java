package com.example.spring_security.service;

import com.example.spring_security.model.Personne;
import com.example.spring_security.repository.PersonneRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneSecuriteService implements UserDetailsService {

    private final PersonneRepository personneRepository;

    public PersonneSecuriteService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personne personne = personneRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Personne non trouvée : " + username));

        return new User(personne.getUsername(), personne.getPassword(), personne.getEnabled(), true, true, true, List.of(new SimpleGrantedAuthority(personne.getRole())));
    }
}
