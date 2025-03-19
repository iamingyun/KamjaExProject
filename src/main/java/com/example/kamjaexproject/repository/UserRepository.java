package com.example.kamjaexproject.repository;

import com.example.kamjaexproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // Spring boot에서 레포지토리는 데이터베이스와 상호작용하는 역할
    //코드 작성 없이 자동 구현(Spring Data JPA)

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email); // Optional<User>를 사용하는 이유는
}
