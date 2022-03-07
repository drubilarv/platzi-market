package com.platzi.market.persistence;


import com.platzi.market.domain.PrincipalUser;
import com.platzi.market.domain.repository.PrincipalUserRepository;
import com.platzi.market.persistence.crud.UsuarioCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.entity.Usuario;
import com.platzi.market.persistence.mapper.ProductMapper;
import com.platzi.market.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements PrincipalUserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;
    @Override
    public PrincipalUser getUser(String username) {
        return mapper.toPrincipalUser( (Usuario) usuarioCrudRepository.findByUsuario(username) );
    }

    @Override
    public Optional<List<PrincipalUser>> getAll() {
        List<Usuario> usuarios = (List<Usuario>)usuarioCrudRepository.findAll();
        return Optional.of(mapper.toPrincipalUsers(usuarios));
    }
}
