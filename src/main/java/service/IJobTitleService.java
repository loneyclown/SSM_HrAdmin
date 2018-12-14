package service;

import entity.JobTitle;

import java.util.Map;

public interface IJobTitleService {
    Map<String, Object> listJobTitleByDepartmentId(Integer id);
    Integer addJobTitle(JobTitle jobTitle);

    Integer delJobTitleById(Integer id);
}
