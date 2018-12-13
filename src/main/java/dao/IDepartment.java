package dao;

import entity.Department;

import java.util.List;
import java.util.Map;

public interface IDepartment {
    List<Department> selectAllDepartmentByCurr(Map<String, Object> map);
    Integer selectCountDeprecatedALL();
}
