package service;

import entity.StaffInfo;

import java.util.Map;

public interface IStaffInfoService {
//    List<User> selectUser(Integer id);

    StaffInfo login(String staffName, String passWord);
    StaffInfo getStaffInfoById(Integer id);
    Map<String, Object> listStaffInfoByCurr(Integer curr, Integer limit);
    Integer addStaffInfo(StaffInfo staffInfo);

    Integer delStaffInfo(Integer id);

//    Map<String, Object> listUserInfo(Integer curr, Integer limit);
//    int addUser(User user);
//    int delUserById(Integer id);

}