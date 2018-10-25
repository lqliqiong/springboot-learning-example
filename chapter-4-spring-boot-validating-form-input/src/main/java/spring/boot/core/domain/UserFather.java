package spring.boot.core.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户实体类
 * <p>
 * Created by bysocket on 21/07/2017.
 */
@Entity
@Data
public class UserFather implements Serializable {

    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 名称
     */
    @NotNull(message = "姓名不能为空")
    private String name;


    /**
     * 名称
     */
    @NotEmpty(message = "姓名不能为空")
    @Size(min = 3, max = 8, message = "姓名长度必须大于 3 且小于 20 字")
    private String name1;

    /**
     * 年龄
     */
//    @NotNull(message = "年龄不能为空")
//    @Range(min=1, max=3)
//    private Integer age;
    @NotNull
    @Digits(integer = 99999, fraction = 0)
    @Range(min=1, max=9)
    private BigDecimal age;

    /**
     * 出生时间
     */
    @NotEmpty(message = "出生时间不能为空")
    private String birthday;

}
