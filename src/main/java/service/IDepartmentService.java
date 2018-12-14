package service;

import entity.Department;

import java.util.Map;

public interface IDepartmentService {
    Map<String, Object> listDepartmentByCurr(Integer curr, Integer limit);
    Map<String, Object> listDepartment();
    Integer addDepartment(Department department);

    Integer delDepartmentById(Integer id);
}
