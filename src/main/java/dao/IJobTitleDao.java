package dao;

import entity.JobTitle;

import java.util.List;

public interface IJobTitleDao {
    List<JobTitle> selectALLJobTitleBydepartmentId(Integer id);

}
