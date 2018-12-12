package service.impl;

import dao.IStaffInfoDao;
import entity.StaffInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IStaffInfoService;
import service.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffInfoServiceImpl implements IStaffInfoService {
    @Autowired
    private IStaffInfoDao staffInfoDao;

//    public List<User> selectUser(Integer id) {
//        return this.userDao.selectUser(id);
//    }

    public StaffInfo login(String staffName, String passWord) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("staffName", staffName);
        map.put("passWord", passWord);
        StaffInfo u = this.staffInfoDao.login(map);
        return u;
    }

//    public StaffInfo getStaffInfoById(Integer id) {
//        return this.staffInfoDao.selectStaffInfoById(id);
//    }

    public StaffInfo getStaffInfoById2(Integer id) {
        StaffInfo s = this.staffInfoDao.selectStaffInfoById2(id);
        System.out.println(s);
        return s;
    }

//    public Map<String, Object> listUserInfo(Integer curr, Integer limit) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        Map<String, Object> req = new HashMap<String, Object>();
//        Integer start = curr==1?0:curr*limit-limit;
//        Integer size = limit;
//        req.put("start", start);
//        req.put("size", size);
//        List<User> list = this.userDao.selectAllUserByCurr(req);
//        Integer total = this.userDao.selectCountUserALL();
//        if(list != null) {
//            map.put("count",list.size() );
//            map.put("list", list);
//        }
//        map.put("total",total );
//        return map;
//    }

//    public int addUser(User user) {
//        return this.userDao.insertUser(user);
//    }

//    public int delUserById(Integer id) {
//        return this.userDao.deleteUserById(id);
//    }

}

