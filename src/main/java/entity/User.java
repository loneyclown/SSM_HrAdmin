package entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;
    private String staffName;
    private Integer staffAge;
    private Integer staffSex;
    private String phone;
    private String entryTime;
    private Integer departmentId;
    private Integer jobId;
    private Integer isTrain;
    private Integer subjectId;
    private Integer staffType;
    private String passWord;
}
