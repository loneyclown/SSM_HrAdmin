package controller;

import entity.Bonus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IBonusService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bonus")
public class BonusController {
    @Autowired
    private IBonusService bonusService;

    @RequestMapping("/listAllBonusByCurr")
    public Map<String, Object> listAllBonusByCurr(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            Map<String, Object> res = this.bonusService.listAllBonusByCurr(curr, limit);
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

    @RequestMapping("/addBonus")
    public Map<String, Object> addBonus(HttpServletRequest request, HttpServletResponse response, Bonus bonus) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("is", false);
        String content = bonus.getContent();
        String bonusTime = bonus.getBonusTime();
        Integer staffId = bonus.getStaffId();
        Integer bonusType = bonus.getBonusType();
        if(content==null||content.equals("")) {
            map.put("msg", "content不能为空！");
        } else if(staffId==null) {
            map.put("msg", "staffId不能为空！");
        } else if(bonusTime==null||bonusTime.equals("")) {
            map.put("msg", "bonusTime不能为空！");
        } else if(bonusType==null) {
            map.put("msg", "bonusType不能为空！");
        } else if(this.bonusService.addBonus(bonus) != -1) {
            map.put("is", true);
            map.put("msg", "添加成功！");
        } else {
            map.put("msg", "添加失败！");
        }
        return map;
    }
}
