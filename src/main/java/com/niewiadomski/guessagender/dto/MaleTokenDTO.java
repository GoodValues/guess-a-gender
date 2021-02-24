package com.niewiadomski.guessagender.dto;

import com.niewiadomski.guessagender.entity.ComplexToken;

public class MaleTokenDTO {

    private Long id;
    private String name;
    private ComplexToken complexToken;

    public MaleTokenDTO(String name) {
        this.name = name;
    }

    public MaleTokenDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MaleTokenDTO() {
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
