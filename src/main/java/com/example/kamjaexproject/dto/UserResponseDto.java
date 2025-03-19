package com.example.kamjaexproject.dto;

import com.example.kamjaexproject.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;

    // User 엔티티를 받아서 Dto로 변환하는 생성자 추가
    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
