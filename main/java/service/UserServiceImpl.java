package service;

import domain.User;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import repository.UserMapper;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByNickname(String nickname) {
        return userMapper.getUserByFixedNickname(nickname);
    }

    @Override
    public boolean registNewUser(User newUser){
        try
        {
            userMapper.insertUser(newUser);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        return true;
    }
}
