package entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Subject implements Serializable {
    private Integer id;
    private String subjectName;
    private String description;
    private Integer isFree;
    private Double price;
    private String time;
}
