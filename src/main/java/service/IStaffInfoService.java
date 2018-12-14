package service;

import entity.StaffInfo;

import java.util.Map;

public interface IStaffInfoService {
    StaffInfo login(String staffName, String passWord);
    StaffInfo getStaffInfoById(Integer id);
    Map<String, Object> listStaffInfoByCurr(Integer curr, Integer limit);
    Integer addStaffInfo(StaffInfo staffInfo);
    Integer delStaffInfo(Integer id);
    Integer updateStaffInfoById(StaffInfo staffInfo);
    Integer updateSubjectIdById(Integer id, Integer subjectId);
}