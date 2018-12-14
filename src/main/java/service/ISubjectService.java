package service;

import entity.Subject;

import java.util.Map;

public interface ISubjectService {
    Map<String, Object> listSubjectByCurr(Integer curr, Integer limit);
    Integer addSubject(Subject subject);
    Integer delSubjectById(Integer id);
    Integer updateSubjectById(Subject subject);
}
