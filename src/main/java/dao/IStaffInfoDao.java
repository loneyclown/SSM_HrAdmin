package dao;
import entity.StaffInfo;

import java.util.List;
import java.util.Map;

public interface IStaffInfoDao {
    StaffInfo login(Map<String, String> map);
    StaffInfo selectStaffInfoById(Integer id);
    List<StaffInfo> selectAllStaffInfoByCurr(Map<String, Object> map);
    Integer selectCountStaffInfoALL();
    Integer insertStaffInfo(StaffInfo staffInfo);
    Integer deleteStaffInfoById(Integer id);
}
