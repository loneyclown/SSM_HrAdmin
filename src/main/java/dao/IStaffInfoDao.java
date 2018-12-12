package dao;
import entity.StaffInfo;

import java.util.List;
import java.util.Map;

public interface IStaffInfoDao {
//    List<User> selectUser(Integer id);

    StaffInfo login(Map<String, String> map);
    StaffInfo selectStaffInfoById(Integer id);

    List<StaffInfo> selectAllStaffInfoByCurr(Map<String, Object> map);
    Integer selectCountStaffInfoALL();


//    User selectUserById(Integer id);
//    List<User> selectAllUserByCurr(Map<String, Object> map);
//    Integer selectCountUserALL();
//    int insertUser(User user);
//    int deleteUserById(Integer id);
}
