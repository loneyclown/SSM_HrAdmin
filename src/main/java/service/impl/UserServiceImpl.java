package service.impl;

import dao.IUserDao;
import entity.User;
import service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

//    public List<User> selectUser(Integer id) {
//        return this.userDao.selectUser(id);
//    }

    public User userVerify(String staffName, String passWord) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("staffName", staffName);
        map.put("passWord", passWord);
        User u = this.userDao.userVerify(map);
        return u;
    }

    public User getUserInfoById(Integer id) {
        return this.userDao.selectUserById(id);
}

    public Map<String, Object> listUserInfo(Integer curr, Integer limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> req = new HashMap<String, Object>();
        Integer start = curr==1?0:curr*limit-limit;
        Integer size = limit;
        req.put("start", start);
        req.put("size", size);
        List<User> list = this.userDao.selectAllUserByCurr(req);
        Integer total = this.userDao.selectCountUserALL();
        if(list != null) {
            map.put("count",list.size() );
            map.put("list", list);
        }
        map.put("total",total );
        return map;
    }

    public int addUser(User user) {
        return this.userDao.insertUser(user);
    }

    public int delUserById(Integer id) {
        return this.userDao.deleteUserById(id);
    }

}

