package service.impl;

import dao.IBonusDao;
import entity.Bonus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IBonusService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BonusServiceImpl implements IBonusService {
    @Autowired
    private IBonusDao bonusDao;

    public Map<String, Object> listAllBonusByCurr(Integer curr, Integer limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> req = new HashMap<String, Object>();
        Integer start = curr==1?0:curr*limit-limit;
        Integer size = limit;
        req.put("start", start);
        req.put("size", size);
        List<Bonus> list = this.bonusDao.selectAllBonusByCurr(req);
        Integer total = this.bonusDao.selectCountBonusALL();
        if(list != null) {
            map.put("count",list.size() );
            map.put("list", list);
        }
        map.put("total",total );
        return map;
    }

    public Integer addBonus(Bonus bonus) {
        return this.bonusDao.insertBonus(bonus);
    }
}
