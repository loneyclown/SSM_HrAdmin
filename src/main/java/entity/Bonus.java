package entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Bonus implements Serializable {
    private Integer id;
    private Integer bonusLevel;
    private String description;
    private String content;
    private Integer staffId;
    private String penaltyEndTime;
    private Integer bonusType;
}
