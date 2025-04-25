package com.xzit.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data

public class Db2 extends Model<Db2> {
    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;
    private String name;
    private Integer balance;
    @Version
    private Integer version;
}
