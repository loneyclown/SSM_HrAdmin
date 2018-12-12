package entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class JobTitle implements Serializable {
    private Integer id;
    private String jobName;
    private Integer departmentId;

    private List<Department> departments;
}
