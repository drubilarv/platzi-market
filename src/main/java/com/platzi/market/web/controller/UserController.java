package com.platzi.market.web.controller;

import com.platzi.market.domain.PrincipalUser;
import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.service.PrincipalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PrincipalUserService principalUserService;

    @GetMapping("/all")
    public ResponseEntity<List<PrincipalUser>> getAll(){
        return principalUserService.getAll()
                .map(users -> new ResponseEntity<>(users, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
