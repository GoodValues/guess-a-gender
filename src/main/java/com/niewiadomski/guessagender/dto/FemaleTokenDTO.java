package com.niewiadomski.guessagender.dto;

import com.niewiadomski.guessagender.entity.ComplexToken;

public class FemaleTokenDTO {

    private Long id;
    private String name;
    private ComplexToken complexToken;

    public FemaleTokenDTO(String name) {
        this.name = name;
    }

    public FemaleTokenDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public FemaleTokenDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComplexToken getComplexToken() {
        return complexToken;
    }

    public void setComplexToken(ComplexToken complexToken) {
        this.complexToken = complexToken;
    }
}
