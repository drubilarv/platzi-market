package com.platzi.market.web.controller;

import com.platzi.market.domain.PrincipalUser;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.domain.service.PrincipalUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private PrincipalUserService principalUserService;
    private PrincipalUser principalUser;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        principalUser = new PrincipalUser();
        principalUser.setIdUser(1);
        principalUser.setUsername("drubilar");
        principalUser.setEmail("daniel@gmail.com");

    }

    @Test
    void getAll_whit_user() {

        Mockito.when(principalUserService.getAll()).thenReturn(Optional.of(Arrays.asList(principalUser)));
        ResponseEntity<List<PrincipalUser>> httpResponse = userController.getAll();
        assertEquals( HttpStatus.OK,httpResponse.getStatusCode());

    }

    @Test
    void getAll_without_user() {

        Mockito.when(principalUserService.getAll()).thenReturn(Optional.of(new ArrayList<PrincipalUser>()));
        ResponseEntity<List<PrincipalUser>> httpResponse = userController.getAll();
        assertEquals(HttpStatus.NOT_FOUND, httpResponse.getStatusCode());

    }
}