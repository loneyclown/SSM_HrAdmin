package service.impl;

import dao.ISubjectDao;
import entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ISubjectService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubjectServiceImpl implements ISubjectService {
    @Autowired
    private ISubjectDao subjectDao;

    public Map<String, Object> listSubjectByCurr(Integer curr, Integer limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> req = new HashMap<String, Object>();
        Integer start = curr==1?0:curr*limit-limit;
        Integer size = limit;
        req.put("start", start);
        req.put("size", size);
        List<Subject> list = this.subjectDao.selectAllSubjectByCurr(req);
        Integer total = this.subjectDao.selectCountSubjectALL();
        if(list != null) {
            map.put("count",list.size() );
            map.put("list", list);
        }
        map.put("total",total );
        return map;
    }

    public Integer addSubject(Subject subject) {
        return this.subjectDao.insertSubject(subject);
    }

    public Integer delSubjectById(Integer id) {
        return this.subjectDao.deleteSubjectById(id);
    }

    public Integer updateSubjectById(Subject subject) {
        return this.subjectDao.updateSubjectById(subject);
    }
}
