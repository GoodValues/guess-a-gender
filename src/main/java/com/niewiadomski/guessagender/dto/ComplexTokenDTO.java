package com.niewiadomski.guessagender.dto;

import com.niewiadomski.guessagender.entity.FemaleToken;
import com.niewiadomski.guessagender.entity.MaleToken;

import java.util.ArrayList;
import java.util.List;

public class ComplexTokenDTO {

    private Long id;
    private List<MaleToken> maleTokens = new ArrayList<>();
    private List<FemaleToken> femaleTokens = new ArrayList<>();

    public ComplexTokenDTO(Long id, List<MaleToken> maleTokens, List<FemaleToken> femaleTokens) {
        this.id = id;
        this.maleTokens = maleTokens;
        this.femaleTokens = femaleTokens;
    }

    public ComplexTokenDTO(List<MaleToken> maleTokens, List<FemaleToken> femaleTokens) {
        this.maleTokens = maleTokens;
        this.femaleTokens = femaleTokens;
    }

    public ComplexTokenDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MaleToken> getMaleTokens() {
        return maleTokens;
    }

    public void setMaleTokens(List<MaleToken> maleTokens) {
        this.maleTokens = maleTokens;
    }

    public List<FemaleToken> getFemaleTokens() {
        return femaleTokens;
    }

    public void setFemaleTokens(List<FemaleToken> femaleTokens) {
        this.femaleTokens = femaleTokens;
    }
}
