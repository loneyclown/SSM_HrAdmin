package dao;
import entity.StaffInfo;

import java.util.List;
import java.util.Map;

public interface IStaffInfoDao {
//    List<User> selectUser(Integer id);

    StaffInfo login(Map<String, String> map);
//    StaffInfo selectStaffInfoById(Integer id);

    StaffInfo selectStaffInfoById2(Integer id);


//    User selectUserById(Integer id);
//    List<User> selectAllUserByCurr(Map<String, Object> map);
//    Integer selectCountUserALL();
//    int insertUser(User user);
//    int deleteUserById(Integer id);
}
