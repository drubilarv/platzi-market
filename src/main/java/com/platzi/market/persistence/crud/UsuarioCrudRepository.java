package com.platzi.market.persistence.crud;


import com.platzi.market.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioCrudRepository extends CrudRepository<Usuario,Integer> {
    //List<Producto> findByIdCategoriaOrderByNombreAsc( int idCategoria );
    Usuario findByUsuario(String usuario );


}
