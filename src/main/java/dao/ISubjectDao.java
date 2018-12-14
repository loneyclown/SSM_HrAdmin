package dao;

import entity.Subject;

import java.util.List;
import java.util.Map;

public interface ISubjectDao {
    List<Subject> selectAllSubjectByCurr(Map<String, Object> map);
    Integer insertSubject(Subject subject);
    Integer deleteSubjectById(Integer id);
    Integer updateSubjectById(Subject subject);
    Integer selectCountSubjectALL();
}
