package controller;

import entity.User;
import org.springframework.web.bind.annotation.RestController;
import service.IUserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

//    @RequestMapping("/showUser.do")
//    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        Integer id = Integer.parseInt(request.getParameter("id"));
//        List<User> Users = this.userService.selectUser(id);
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(Users));
//        response.getWriter().close();
//    }


    @RequestMapping("/userVerify")
    public Map<String, Object> userVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String staffName = request.getParameter("staffName");
        String passWord = request.getParameter("passWord");
        Map<String, Object> map = new HashMap<String, Object>();
        User u = this.userService.userVerify(staffName, passWord);
        if(u == null) {
            map.put("is", false);
            map.put("msg", "用户名或者密码错误！");
        } else {
            map.put("is", true);
            map.put("msg", "登录成功！");
            map.put("staffName", u.getStaffName());
        }
        return map;
    }

    @RequestMapping("/getUserInfoById")
    public Map<String, Object> getUserInfoById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String s_id = request.getParameter("id");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("is", false);
        if(s_id.equals("")) {
            map.put("msg", "Id不能为空！");
        } else {
            User u = this.userService.getUserInfoById(Integer.parseInt(s_id));
            if(u == null) {
                map.put("msg", "用户不存在！");
            } else {
                map.put("is", true);
                map.put("staffName", u);
            }
        }
        return map;
    }

    @RequestMapping("/listUserInfo")
    public Map<String, Object> listUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Map<String, Object> map = new HashMap<String, Object>();
        String s_curr = request.getParameter("curr");
        String s_limit = request.getParameter("limit");
        map.put("is", false);
        if(s_curr.equals("")) {
            map.put("msg", "curr不能为空！");
        } else if(s_limit.equals("")) {
            map.put("msg", "limit不能为空！");
        } else {
            map.put("is", true);
            Integer curr = Integer.parseInt(s_curr);
            Integer limit = Integer.parseInt(s_limit);
            Map<String, Object> res = this.userService.listUserInfo(curr, limit);
            if(res.get("list")==null) {
                map.put("count", 0);
            } else {
                map.put("count", res.get("count"));
                map.put("data", res.get("list"));
            }
            map.put("is", true);
            map.put("total", res.get("total"));
        }
        return map;
    }

    @RequestMapping("/addUser")
    public Map<String, Object> addUser(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("is", false);
        Integer state = this.userService.addUser(user);
        if(state != -1) {
            map.put("is", true);
            map.put("msg", "添加成功！");
        }
        return map;
    }

    @RequestMapping("/delUserById")
    public Map<String, Object> delUserById(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String s_id = request.getParameter("id");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("is", false);
        if(s_id.equals("")) {
            map.put("msg", "Id不能为空！");
        } else {
            Integer state = this.userService.delUserById(Integer.parseInt(s_id));
            if(state != -1) {
                map.put("is", true);
                map.put("msg", "删除成功！");
            }
        }
        return map;
    }
}
