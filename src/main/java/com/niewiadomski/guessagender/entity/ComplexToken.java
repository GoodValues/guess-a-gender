package com.niewiadomski.guessagender.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "complex_token")
public class ComplexToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "complexToken", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<MaleToken> maleTokens = new ArrayList<>();

    @OneToMany(mappedBy = "complexToken", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<FemaleToken> femaleTokens = new ArrayList<>();

    public ComplexToken(Long id, List<MaleToken> maleTokens, List<FemaleToken> femaleTokens) {
        this.id = id;
        this.maleTokens = maleTokens;
        this.femaleTokens = femaleTokens;
    }

    public ComplexToken(List<MaleToken> maleTokens, List<FemaleToken> femaleTokens) {
        this.maleTokens = maleTokens;
        this.femaleTokens = femaleTokens;
    }

    public ComplexToken() {
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

    public void addToMaleTokens(MaleToken maleToken) {
        maleTokens.add(maleToken);
    }

    public void addToFemaleTokens(FemaleToken femaleToken) {
        femaleTokens.add(femaleToken);
    }


}
