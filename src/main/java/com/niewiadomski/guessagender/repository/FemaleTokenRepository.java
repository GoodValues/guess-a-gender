package com.niewiadomski.guessagender.repository;

import com.niewiadomski.guessagender.entity.FemaleToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FemaleTokenRepository extends JpaRepository<FemaleToken,Long> {
}
