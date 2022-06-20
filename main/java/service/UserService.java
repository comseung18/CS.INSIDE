package service;


import domain.User;
import java.util.List;


public interface UserService {
    List<User> getAllUsers();

    // id 로 유저 정보 조회
    User getUserById(String id);
    // 닉네임으로 유저 정보 조회
    User getUserByNickname(String nickname);

    // 신규 유저 가입 성공시 true, 실패시 false 을 반환
    boolean registNewUser(User newUser);
}
