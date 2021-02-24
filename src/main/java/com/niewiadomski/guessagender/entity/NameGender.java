package com.niewiadomski.guessagender.entity;

import java.io.Serializable;

public class NameGender implements Serializable {

    public NameGender() {
    }

    private String name;

    private String gender;

    private Float probability;

    private Integer count;

    public boolean isMale() {
        return Gender.MALE.equals(this.getGenderType());
    }

    public boolean isFemale() {
        return Gender.FEMALE.equals(this.getGenderType());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Gender getGenderType() {
        if (this.gender == null) {
            return Gender.INCONCLUSIVE;
        }
        return Gender.valueOf(this.gender.toUpperCase());
    }

    public Float getProbability() {
        return probability;
    }

    public void setProbability(Float probability) {
        this.probability = probability;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Name{" + "name=" + name + ", gender=" + gender + ", probability=" + probability + ", count=" + count + '}';
    }


}
