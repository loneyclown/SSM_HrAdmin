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
}
