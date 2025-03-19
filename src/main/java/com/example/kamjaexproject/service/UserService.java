package com.example.kamjaexproject.service;

import com.example.kamjaexproject.dto.UserRequestDto;
import com.example.kamjaexproject.dto.UserResponseDto;
import com.example.kamjaexproject.entity.User;
import com.example.kamjaexproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository; // 🔥 반드시 final 추가

    // @Autowired 생성자 삭제 -> @RequiredArgsConstructor가 알아서 생성자를 만듦

    @Transactional
    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
        Optional<User> foundUser = userRepository.findByEmail(userRequestDto.getEmail());
        if (foundUser.isPresent()) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }

        User user = User.builder()
                .username(userRequestDto.getUsername())
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .build();

        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser);
    }

    public UserResponseDto login(UserRequestDto userRequestDto) {
        Optional<User> userOptional = userRepository.findByEmail(userRequestDto.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(userRequestDto.getPassword())) {
                return new UserResponseDto(user);
            } else {
                throw new RuntimeException("비밀번호가 틀렸습니다.");
            }
        } else {
            throw new RuntimeException("사용자가 존재하지 않습니다.");
        }
    }
}



//@Service // 1. 서비스 계층으로 선언
//@RequiredArgsConstructor
//public class UserService {
//    private UserRepository userRepository;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    // 3. 회원가입 메서드
//    @Transactional
//    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
//        // 4. 중복된 useremail이 있는지 확인
//        Optional<User> foundUser = userRepository.findByEmail(userRequestDto.getEmail());
//        if (foundUser.isPresent()) {
//            throw new RuntimeException("이미 존재하는 이메일입니다.");
//        }
//
//        // 5. User 엔티티 생성 (비밀번호 암호화 없이 저장)
//        User user = User.builder()
//                .username(userRequestDto.getUsername())
//                .email(userRequestDto.getEmail())
//                .password(userRequestDto.getPassword())
//                .build();
//
//        // 6. DB에 저장
//        User savedUser = userRepository.save(user);
//
//        // 7. UserResponseDto로 변환하여 반환
//        return new UserResponseDto(savedUser);
//    }
//
//    // 8. 로그인 메서드
//    public UserResponseDto login(UserRequestDto userRequestDto) {
//        Optional<User> userOptional = userRepository.findByEmail(userRequestDto.getEmail());
//
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            if (user.getPassword().equals(userRequestDto.getPassword())) {
//                return new UserResponseDto(user);
//            } else {
//                throw new RuntimeException("비밀번호가 틀렸습니다.");
//            }
//        } else {
//            throw new RuntimeException("사용자가 존재하지 않습니다.");
//        }
//    }
//}
