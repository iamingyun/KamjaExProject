package com.example.kamjaexproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // 테이블과 링크될 클래스
@Getter // 클래스 내 모든 필드의 Getter 메소드 자동 생성
@Data
@NoArgsConstructor // 기본 생성자 자동 추가
@AllArgsConstructor
@Builder // 해당 클래스의 빌더 패턴 클래스 생성
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id") // @Column은 테이블의 칼럼임을 표시, 필수X, 기본값 외에 변경이 필요한 옵션이 존재할 경우 사용
    private Long id;

    @Column(nullable = false)
    private String email;


    @Column(nullable = false, unique = true) // username은 중복되지 않도록 unique 추가
    private String username;

    @Column(nullable = false, unique = true) // email도 unique 추가 (이메일 중복 방지)
    private String password;
}
