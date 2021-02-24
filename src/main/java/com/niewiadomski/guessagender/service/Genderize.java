package com.niewiadomski.guessagender.service;

import com.niewiadomski.guessagender.entity.NameGender;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public interface Genderize {

    NameGender getGender(String name);

    List<NameGender> getGenders(String... names);

    NameGender getGender(String name, Locale locale);

    List<NameGender> getGenders(String[] names, Locale locale);

}
