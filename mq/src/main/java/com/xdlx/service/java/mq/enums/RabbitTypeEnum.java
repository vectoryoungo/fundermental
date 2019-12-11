package com.xdlx.service.java.mq.enums;

public enum RabbitTypeEnum {

    ORDER(1,"订单"),
    REGIST(2,"注册");

    private Integer type;
    private String description;

    RabbitTypeEnum(Integer type, String description) {
        this.type = type;
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static RabbitTypeEnum getByValues(Integer type) {
        for (RabbitTypeEnum rabbitTypeEnum:values()) {
            if (rabbitTypeEnum.type.equals(type)) {
                return rabbitTypeEnum;
            }
        }
        return null;
    }
}
