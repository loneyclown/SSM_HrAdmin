package entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Department implements Serializable {
    private Integer id;
    private String departmentName;

    private List<JobTitle> jobTitles;
}
