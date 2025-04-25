package com.xzit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Emp {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String empName;
    private String loginName;
    @TableField(exist = false)
    private String loginPassword;
    private Integer age;
    private String gender;
    private String deptName;
    private Integer status;
    @TableField(exist = false)
    private Integer deleted;
    private String addr;

}
