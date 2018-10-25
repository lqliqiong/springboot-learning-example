package demo.springboot.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lq
 * @CreateTime:2018-10-13 15:59
 * @Description:todo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private  int  id;

    private  String  groupId;

    private  String  name;
}
