package com.niewiadomski.guessagender.repository;

import com.niewiadomski.guessagender.entity.ComplexToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplexTokenRepository extends JpaRepository<ComplexToken,Long> {
}
