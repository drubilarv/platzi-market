package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.domain.PrincipalUser;
import com.platzi.market.persistence.entity.Categoria;
import com.platzi.market.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUsuario",target = "idUser"),
            @Mapping(source = "usuario",target = "username"),
            @Mapping(source = "correo", target = "email")
    })
    PrincipalUser toPrincipalUser(Usuario usuario);
    List<PrincipalUser> toPrincipalUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    @Mapping(target = "password", ignore = true)
    Usuario toUsuario(PrincipalUser user);
}
