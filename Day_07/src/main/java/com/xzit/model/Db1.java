package com.xzit.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.xzit.myEnum.statusEnum;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Db1 extends Model<Db1> {
    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;
    private String name;
    @TableField(exist = false)
    private String password;
    private statusEnum status;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
