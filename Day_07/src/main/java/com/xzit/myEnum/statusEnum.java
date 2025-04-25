package com.xzit.myEnum;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum statusEnum implements IEnum<Integer> {
    INACTIVE(0,"未激活"),
    ACTIVE(1,"已激活");

    private final Integer statusValue;
    private final String statusDesc;

    statusEnum(Integer statusValue, String statusDesc) {
        this.statusValue = statusValue;
        this.statusDesc = statusDesc;
    }

    public String toString(){
        return this.statusDesc;
    }

    @Override
    public Integer getValue() {
        return this.statusValue;
    }
}
