package service.impl;

import dao.IJobTitleDao;
import entity.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IJobTitleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobTitleServiceImpl implements IJobTitleService {
    @Autowired
    private IJobTitleDao jobTitleDao;
    public Map<String, Object> listJobTitleByDepartmentId(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<JobTitle> list = this.jobTitleDao.selectALLJobTitleBydepartmentId(id);
        if(list != null) {
            map.put("list", list);
        }
        return map;
    }
}
