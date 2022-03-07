package com.platzi.market.domain.service;

import com.platzi.market.domain.PrincipalUser;
import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.PrincipalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PrincipalUserService {

    @Autowired
    private PrincipalUserRepository principalUserRepository;

    public PrincipalUser getUser(String username){
        return principalUserRepository.getUser(username);
    }
    public Optional<List<PrincipalUser>> getAll(){
        return principalUserRepository.getAll();
    }
}
