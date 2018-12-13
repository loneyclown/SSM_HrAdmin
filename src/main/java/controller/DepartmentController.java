package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IDepartmentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/listDepartmentByCurr")
    public Map<String, Object> listDepartmentByCurr(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            Map<String, Object> res = this.departmentService.listDepartmentByCurr(curr, limit);
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

    @RequestMapping("/listDepartment")
    public Map<String, Object> listDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("is", true);
        Map<String, Object> res = this.departmentService.listDepartment();
        map.put("data", res.get("list"));
        return map;
    }
}
