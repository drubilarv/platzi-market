package com.platzi.market.domain.service;

import com.platzi.market.domain.PrincipalUser;
import com.platzi.market.domain.repository.PrincipalUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PrincipalUserServiceTest {

    @Mock
    private PrincipalUserRepository principalUserRepository;

    @InjectMocks
    private PrincipalUserService principalUserService;

    private PrincipalUser user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        user = new PrincipalUser();
        user.setIdUser(1);
        user.setUsername("drubilar");
        user.setEmail("daniel.rubilar.valenzuela@gmail.com");
        user.setPassword("123");
    }

     @Test
    void getUser() {
        when(principalUserRepository.getUser(user.getUsername())).thenReturn(user);
        assertNotNull(principalUserService.getUser(user.getUsername()));
    }

    @Test
    void getAll() {
        when(principalUserRepository.getAll()).thenReturn(Optional.of(Arrays.asList(user)));
        assertNotNull(principalUserService.getAll());
        assertEquals(user.getUsername(), "drubilar");


    }
}