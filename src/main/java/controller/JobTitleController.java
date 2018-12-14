package controller;

import entity.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IJobTitleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jobTitle")
public class JobTitleController {
    @Autowired
    private IJobTitleService jobTitleService;

    @RequestMapping("/listJobTitleByDepartmentId")
    public Map<String, Object> listJobTitleByDepartmentId(HttpServletRequest request, HttpServletResponse response, JobTitle jobTitle) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer departmentId = jobTitle.getDepartmentId();
        map.put("is", false);
        if(departmentId==null) {
            map.put("msg", "departmentId不能为空！");
        } else {
            map.put("is", true);
            map.put("data", this.jobTitleService.listJobTitleByDepartmentId(departmentId).get("list"));
        }
        return map;
    }

    @RequestMapping("/addJobTitle")
    public Map<String, Object> addJobTitle(HttpServletRequest request, HttpServletResponse response, JobTitle jobTitle) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("is", false);
        String jobName = jobTitle.getJobName();
        Integer departmentId = jobTitle.getDepartmentId();
        if(jobName==null||jobName.equals("")) {
            map.put("msg", "jobName不能为空！");
        } else if(departmentId==null) {
            map.put("msg", "departmentId不能为空！");
        } else if(this.jobTitleService.addJobTitle(jobTitle) != -1) {
            map.put("is", true);
            map.put("msg", "添加成功");
        } else {
            map.put("msg", "添加失败");
        }
        return map;
    }

    @RequestMapping("/delJobTitleById")
    public Map<String, Object> delJobTitleById(HttpServletRequest request, HttpServletResponse response, JobTitle jobTitle) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("is", false);
        Integer id = jobTitle.getId();
        if(id==null) {
            map.put("msg", "id不能为空！");
        } else if(this.jobTitleService.delJobTitleById(id) != -1) {
            map.put("is", true);
            map.put("msg", "删除成功");
        } else {
            map.put("msg", "删除失败");
        }
        return map;
    }
}
