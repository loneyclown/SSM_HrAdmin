package dao;

import entity.Bonus;

import java.util.List;
import java.util.Map;

public interface IBonusDao {
    List<Bonus> selectAllBonusByCurr(Map<String, Object> map);
    Integer selectCountBonusALL();
    Integer insertBonus(Bonus bonus);
//    Integer insertSubject(Subject subject);
//    Integer deleteSubjectById(Integer id);
//    Integer updateSubjectById(Subject subject);
}
