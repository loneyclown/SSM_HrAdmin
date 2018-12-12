package service;

import entity.User;
import java.util.List;
import java.util.Map;

public interface IUserService {
//    List<User> selectUser(Integer id);

    User userVerify(String staffName, String passWord);
    User getUserInfoById(Integer id);
    Map<String, Object> listUserInfo(Integer curr, Integer limit);
    int addUser(User user);
    int delUserById(Integer id);

}