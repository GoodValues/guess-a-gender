package com.niewiadomski.guessagender;

import com.niewiadomski.guessagender.dto.ComplexTokenDTO;
import com.niewiadomski.guessagender.entity.ComplexToken;
import com.niewiadomski.guessagender.entity.FemaleToken;
import com.niewiadomski.guessagender.entity.MaleToken;
import com.niewiadomski.guessagender.mapper.ComplexTokenMapper;
import com.niewiadomski.guessagender.service.TokenService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TokenServiceTest {

    TokenService tokenService;
    List<MaleToken> maleTokens;
    List<FemaleToken> femaleTokens;

    @Before
    public void setUp() throws Exception {
        tokenService = new TokenService();
        maleTokens = new ArrayList<>();
        femaleTokens = new ArrayList<>();
    }

    @Test
    public void checkSpecificTokensByCreatingComplexToken() {
        ComplexToken complexToken = new ComplexToken();
        complexToken.setFemaleTokens(null);
        complexToken.setMaleTokens(null);
        assertNull(complexToken.getFemaleTokens());
        assertNull(complexToken.getMaleTokens());
    }

    @Test
    public void check2Male1FemaleTokensAreAdded() {
        //given
        tokenService = mock(TokenService.class);
        //when
        when(tokenService.getComplexTokenFirstOptionChecked("Adam Robert Maria")).thenReturn(return2Male1FemaleTokens());
        //then
        Assert.assertEquals(tokenService.getComplexTokenFirstOptionChecked("Adam Robert Maria").getFemaleTokens().size(), 1);
        Assert.assertEquals(tokenService.getComplexTokenFirstOptionChecked("Adam Robert Maria").getMaleTokens().size(), 2);
    }

    @Test
    public void check1Male0FemaleTokensAreAdded() {
        //given
        tokenService = mock(TokenService.class);
        //when
        when(tokenService.getComplexTokenFirstOptionChecked("Adam")).thenReturn(return1Male0FemaleTokens());
        //then
        Assert.assertEquals(tokenService.getComplexTokenFirstOptionChecked("Adam").getFemaleTokens().size(), 0);
        Assert.assertEquals(tokenService.getComplexTokenFirstOptionChecked("Adam").getMaleTokens().size(), 1);
        Assert.assertTrue(tokenService.getComplexTokenFirstOptionChecked("Adam").getFemaleTokens().isEmpty());
    }

    @Test
    public void check0Male2FemaleTokensAreAdded() {
        //given
        tokenService = mock(TokenService.class);
        //when
        when(tokenService.getComplexTokenFirstOptionChecked("Maria Monika")).thenReturn(return0Male2FemaleTokens());
        //then
        Assert.assertEquals(tokenService.getComplexTokenFirstOptionChecked("Maria Monika").getFemaleTokens().size(), 2);
        Assert.assertEquals(tokenService.getComplexTokenFirstOptionChecked("Maria Monika").getMaleTokens().size(), 0);
        Assert.assertTrue(tokenService.getComplexTokenFirstOptionChecked("Maria Monika").getMaleTokens().isEmpty());
    }


    private ComplexTokenDTO return2Male1FemaleTokens() {
        maleTokens.add(new MaleToken("Adam"));
        maleTokens.add(new MaleToken("Robert"));
        femaleTokens.add(new FemaleToken("Maria"));
        ComplexToken complexToken = new ComplexToken(maleTokens, femaleTokens);
        return ComplexTokenMapper.INSTANCE.complexTokenToDTO(complexToken);
    }

    private ComplexTokenDTO return1Male0FemaleTokens() {
        maleTokens.add(new MaleToken("Adam"));
        ComplexToken complexToken = new ComplexToken(maleTokens, femaleTokens);
        return ComplexTokenMapper.INSTANCE.complexTokenToDTO(complexToken);
    }

    private ComplexTokenDTO return0Male2FemaleTokens() {
        femaleTokens.add(new FemaleToken("Maria"));
        femaleTokens.add(new FemaleToken("Monika"));
        ComplexToken complexToken = new ComplexToken(maleTokens, femaleTokens);
        return ComplexTokenMapper.INSTANCE.complexTokenToDTO(complexToken);
    }

}