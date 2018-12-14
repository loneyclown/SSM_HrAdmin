package service;

import entity.Bonus;

import java.util.List;
import java.util.Map;

public interface IBonusService {
    Map<String, Object> listAllBonusByCurr(Integer curr, Integer limit);
    Integer addBonus(Bonus bonus);
}
