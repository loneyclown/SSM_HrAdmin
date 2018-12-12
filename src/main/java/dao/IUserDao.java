package dao;
import entity.User;

import java.util.List;
import java.util.Map;

public interface IUserDao {
//    List<User> selectUser(Integer id);

    User userVerify(Map<String, String> map);
    User selectUserById(Integer id);
    List<User> selectAllUserByCurr(Map<String, Object> map);
    Integer selectCountUserALL();
    int insertUser(User user);
    int deleteUserById(Integer id);
}
