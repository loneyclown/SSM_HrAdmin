package controller;

import entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ISubjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private ISubjectService subjectService;

    @RequestMapping("/listSubjectByCurr")
    public Map<String, Object> listSubjectByCurr(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        String s_curr = request.getParameter("curr");
        String s_limit = request.getParameter("limit");
        map.put("is", false);
        if(s_curr.equals("")) {
            map.put("msg", "curr不能为空！");
        } else if(s_limit.equals("")) {
            map.put("msg", "limit不能为空！");
        } else {
            map.put("is", true);
            Integer curr = Integer.parseInt(s_curr);
            Integer limit = Integer.parseInt(s_limit);
            Map<String, Object> res = this.subjectService.listSubjectByCurr(curr, limit);
            if(res.get("list")==null) {
                map.put("count", 0);
            } else {
                map.put("count", res.get("count"));
                map.put("data", res.get("list"));
            }
            map.put("is", true);
            map.put("total", res.get("total"));
        }
        return map;
    }

    @RequestMapping("/addSubject")
    public Map<String, Object> addSubject(HttpServletRequest request, HttpServletResponse response, Subject subject) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("is", false);
        String subjectName = subject.getSubjectName();
        Integer isFree = subject.getIsFree();
        Double price = subject.getPrice();
        if (isFree==null) {
            subject.setIsFree(0);
            subject.setPrice(0.00);
        }
        if(subjectName==null||subjectName.equals("")) {
            map.put("msg", "subjectName不能为空！");
        } else if(isFree!=null&&price==null){
            map.put("msg", "price不能为空！");
        } else if(this.subjectService.addSubject(subject) != -1){
            map.put("is", true);
            map.put("msg", "添加成功！");
        } else {
            map.put("msg", "添加失败！");
        }
        return map;
    }

    @RequestMapping("/delSubjectById")
    public Map<String, Object> delSubjectById(HttpServletRequest request, HttpServletResponse response, Subject subject) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("is", false);
        Integer id = subject.getId();
        if(id==null) {
            map.put("msg", "id不能为空！");
        } else if(this.subjectService.delSubjectById(id) != -1) {
            map.put("is", true);
            map.put("msg", "删除成功！");
        } else {
            map.put("msg", "删除失败！");
        }
        return map;
    }

    @RequestMapping("/updateSubjectById")
    public Map<String, Object> updateSubjectById(HttpServletRequest request, HttpServletResponse response, Subject subject) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("is", false);
        Integer id = subject.getId();
        String subjectName = subject.getSubjectName();
        Integer isFree = subject.getIsFree();
        Double price = subject.getPrice();
        if (isFree==null) {
            subject.setIsFree(0);
            subject.setPrice(0.00);
        }
        if(id==null){
            map.put("msg", "id不能为空！");
        }
        if(subjectName==null||subjectName.equals("")) {
            map.put("msg", "subjectName不能为空！");
        } else if(isFree!=null&&price==null){
            map.put("msg", "price不能为空！");
        } else if(this.subjectService.updateSubjectById(subject) != -1){
            map.put("is", true);
            map.put("msg", "修改成功！");
        } else {
            map.put("msg", "修改失败！");
        }
        return map;
    }
}
