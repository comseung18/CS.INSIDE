package repository;


import domain.User;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UserMapper{

    List<User> getAllUsers();
    User getUserByFixedNickname(String nickname);
    User getUserById(String id);
    User getUserByIdPw(User user);

    int insertUser(User newUser) throws DuplicateKeyException;
}
