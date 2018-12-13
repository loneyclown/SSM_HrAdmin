package service;

import java.util.Map;

public interface IJobTitleService {
    Map<String, Object> listJobTitleByDepartmentId(Integer id);
}
