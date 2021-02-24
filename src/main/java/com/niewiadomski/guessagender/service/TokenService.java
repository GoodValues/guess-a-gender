package com.niewiadomski.guessagender.service;

import com.niewiadomski.guessagender.entity.ComplexToken;
import com.niewiadomski.guessagender.entity.NameGender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    GenderizeService genderizeService;

    @Autowired
    public TokenService(GenderizeService genderizeService) {
        this.genderizeService = genderizeService;
    }

    public ComplexToken getComplexTokenFirstOptionChecked(String name) {
        String[] names = name.split(" ");
        String firstName = names[0];
        NameGender nameGender = genderizeService.getGender(firstName);

        return null;
    }
}
