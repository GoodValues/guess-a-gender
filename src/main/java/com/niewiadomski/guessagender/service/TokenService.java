package com.niewiadomski.guessagender.service;

import com.niewiadomski.guessagender.dto.ComplexTokenDTO;
import com.niewiadomski.guessagender.entity.ComplexToken;
import com.niewiadomski.guessagender.entity.FemaleToken;
import com.niewiadomski.guessagender.entity.MaleToken;
import com.niewiadomski.guessagender.entity.NameGender;
import com.niewiadomski.guessagender.mapper.ComplexTokenMapper;
import com.niewiadomski.guessagender.repository.FemaleTokenRepository;
import com.niewiadomski.guessagender.repository.MaleTokenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TokenService {

    GenderizeService genderizeService;
    MaleTokenRepository maleTokenRepository;
    FemaleTokenRepository femaleTokenRepository;

    Logger logger = LoggerFactory.getLogger(TokenService.class);

    @Autowired
    public TokenService(GenderizeService genderizeService, MaleTokenRepository maleTokenRepository, FemaleTokenRepository femaleTokenRepository) {
        this.genderizeService = genderizeService;
        this.maleTokenRepository = maleTokenRepository;
        this.femaleTokenRepository = femaleTokenRepository;
    }


    public TokenService() {
    }


    public ComplexTokenDTO getComplexTokenFirstOptionChecked(String givenName) {
        String[] names = givenName.split(" ");
        String firstName = names[0];
        NameGender nameGender = genderizeService.getGender(firstName);
        logGender(nameGender);

        List<MaleToken> maleTokens = new ArrayList<>();
        List<FemaleToken> femaleTokens = new ArrayList<>();

        List<NameGender> genders = genderizeService.getGenders(names);

        for (NameGender gender:genders) {
            if(gender.isMale()) {
                MaleToken maleToken = new MaleToken(gender.getName());
                maleTokenRepository.save(maleToken);
                maleTokens.add(maleToken);
            }
            if(gender.isFemale()) {
                FemaleToken femaleToken = new FemaleToken(gender.getName());
                femaleTokenRepository.save(femaleToken);
                femaleTokens.add(femaleToken);
            }
        }

        ComplexToken complexToken = new ComplexToken(maleTokens, femaleTokens);
        return ComplexTokenMapper.INSTANCE.complexTokenToDTO(complexToken);
    }

    private void logGender(NameGender nameGender) {
        if(nameGender.getName().isEmpty())
        logger.info("Gender for given name is INCONCLUSIVE");
        else logger.info("Gender for name " + nameGender.getName() + " is " + nameGender.getGender());
    }



    public ComplexTokenDTO getComplexTokenSecondOptionChecked(String givenName) {
        String[] names = givenName.split(" ");

        List<MaleToken> maleTokens = new ArrayList<>();
        List<FemaleToken> femaleTokens = new ArrayList<>();
        boolean isInconclusive = false;

        List<NameGender> genders = genderizeService.getGenders(names);

        for (NameGender gender:genders) {
            if(gender.isInconclusive()) {
                isInconclusive = true;
                continue;
            }
            if(gender.isMale()) {
                MaleToken maleToken = new MaleToken(gender.getName());
                maleTokenRepository.save(maleToken);
                maleTokens.add(maleToken);
            }
            if(gender.isFemale()) {
                FemaleToken femaleToken = new FemaleToken(gender.getName());
                femaleTokenRepository.save(femaleToken);
                femaleTokens.add(femaleToken);
            }
        }

        return checkConditionsForSecondOption(maleTokens, femaleTokens, isInconclusive);
    }



    private ComplexTokenDTO checkConditionsForSecondOption(List<MaleToken> maleTokens, List<FemaleToken> femaleTokens, boolean isInconclusive) {
        ComplexToken complexToken = new ComplexToken(maleTokens, femaleTokens);

        if(isInconclusive) {
            logger.info("Gender for given name is INCONCLUSIVE");
        }
        if(maleTokens.size()>femaleTokens.size()) {
            logger.info("Gender for given name is MALE");
        }

        if(femaleTokens.size()>maleTokens.size()) {
            logger.info("Gender for given name is FEMALE");
        }

        else {
            logger.info("Gender for given name is INCONCLUSIVE");
        }

        return ComplexTokenMapper.INSTANCE.complexTokenToDTO(complexToken);
    }

}
