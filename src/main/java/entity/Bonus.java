package entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Bonus implements Serializable {
    private Integer id;
    private String description;
    private String content;
    private String bonusTime;
    private Integer bonusType;
    private Integer staffId;
    private List<StaffInfo> staffInfos;
}
