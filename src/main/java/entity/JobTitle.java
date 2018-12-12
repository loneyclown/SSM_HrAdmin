package entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class JobTitle implements Serializable {
    private Integer id;
    private String jobName;
    private Integer departmentId;
}
