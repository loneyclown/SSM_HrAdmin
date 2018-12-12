package entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TransferHistory implements Serializable {
    private Integer id;
    private Integer oldDepartmentId;
    private Integer newDepartmentId;
    private Integer oldJobId;
    private Integer newJobId;
    private String time;
    private Integer staffId;
}
