package service;

import java.util.Map;

public interface IDepartmentService {
    Map<String, Object> listDepartmentByCurr(Integer curr, Integer limit);
}
