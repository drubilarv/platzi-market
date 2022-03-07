package com.platzi.market.domain.repository;

import com.platzi.market.domain.PrincipalUser;

import java.util.List;
import java.util.Optional;

public interface PrincipalUserRepository {

    PrincipalUser getUser(String username);
    Optional<List<PrincipalUser>> getAll();
}
