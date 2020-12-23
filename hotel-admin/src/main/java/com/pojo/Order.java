package com.pojo;

import java.util.Date;

public class Order {
    private Integer id;
    private String orderNum;
    private Double orderMoney;
    private String remark;
    private String orderStatus;
    private Integer iriId;
    private Date createDate;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", orderMoney=" + orderMoney +
                ", remark='" + remark + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", iriId=" + iriId +
                ", createDate=" + createDate +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Double getOderMoney() {
        return orderMoney;
    }

    public void setOderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getIriId() {
        return iriId;
    }

    public void setIriId(Integer iriId) {
        this.iriId = iriId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
