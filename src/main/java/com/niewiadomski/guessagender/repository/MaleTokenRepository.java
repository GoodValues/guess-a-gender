package com.niewiadomski.guessagender.repository;

import com.niewiadomski.guessagender.entity.MaleToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaleTokenRepository extends JpaRepository<MaleToken,Long> {
}
