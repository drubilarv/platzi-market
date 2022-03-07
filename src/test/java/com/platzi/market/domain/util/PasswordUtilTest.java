package com.platzi.market.domain.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.platzi.market.domain.util.PasswordUtil.SecurityLevel.*;
import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {




    @Test
    void WEAK_when_has_less_than_8_letters(){
        assertEquals(WEAK,PasswordUtil.assessPassword("12345678"));
    }

    @Test
    void  WEAK_when_has_only_letters(){
        assertEquals(WEAK,PasswordUtil.assessPassword("aaaaaaaaaa"));
    }

    @Test
    void  WEAK_when_has_only_numbers(){
        assertEquals(WEAK,PasswordUtil.assessPassword("111111111"));
    }

    @Test
    void MEDIUM_when_it_has_numbers_and_letters(){
        assertEquals(MEDIUM,PasswordUtil.assessPassword("asd12311q"));
    }

    @Test
    void STRONG_where_it_hass_number_letters_and_symbols(){
        assertEquals(STRONG,PasswordUtil.assessPassword("123asd!."));
    }
}