package com.platzi.market.domain.service;

import com.platzi.market.domain.PrincipalUser;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlatziUserDetailsService implements UserDetailsService {

    @Autowired
    private PrincipalUserService principalUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PrincipalUser usuario = principalUserService.getUser(username);
        User.UserBuilder builder= null;

        if( usuario!=null ){
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(usuario.getPassword());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        }else{
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return builder.build();
        //return new User("drubilar","{noop}platzi", new ArrayList<>());
    }
}
