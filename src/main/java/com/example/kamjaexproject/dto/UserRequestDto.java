package com.example.kamjaexproject.dto;


import lombok.Data;

@Data
// 클라이언트가 보내는 요청 데이터, 사용자가 입력한 회원가입 정보를 서버로 전송할 때 사용
public class UserRequestDto {
    private Long id;
    private String username;
    private String password;
    private String email;

    public UserRequestDto(Long id,String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
