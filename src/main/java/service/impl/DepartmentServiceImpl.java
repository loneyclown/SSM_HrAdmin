package service.impl;

import dao.IDepartmentDao;
import entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IDepartmentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private IDepartmentDao departmentDao;

    public Map<String, Object> listDepartmentByCurr(Integer curr, Integer limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> req = new HashMap<String, Object>();
        Integer start = curr==1?0:curr*limit-limit;
        Integer size = limit;
        req.put("start", start);
        req.put("size", size);
        List<Department> list = this.departmentDao.selectAllDepartmentByCurr(req);
        Integer total = this.departmentDao.selectCountDeprecatedALL();
        for (int i = 0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        if(list != null) {
            map.put("count",list.size() );
            map.put("list", list);
        }
        map.put("total",total );
        return map;
    }

    public Map<String, Object> listDepartment() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Department> list = this.departmentDao.selectAllDepartment();
        if(list != null) {
            map.put("list", list);
        }
        return map;
    }
}
