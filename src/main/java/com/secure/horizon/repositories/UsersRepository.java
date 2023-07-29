package com.secure.horizon.repositories;

import org.springframework.data.repository.CrudRepository;


import com.secure.horizon.model.Usuario;

public interface UsersRepository extends CrudRepository<Usuario, Integer> {

}
