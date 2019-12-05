package com.zhg.javakc.modules.salesprice.entity;

import com.zhg.javakc.base.entity.BaseEntity;

import java.util.Date;
import java.util.List;

public class SalesPriceEntity extends BaseEntity<SalesPriceEntity> {

    private String spId;
//    private String groupId;
//    private String clientId;
//    private String goodsId;
    private String spPrice;
    private Date effectiveDate;
    private Date expiryDate;
    private Integer version;
    private Date changePriceDate;
    private Integer status;
    private List<String> clientList;

    public List<String> getClientList() {
        return clientList;
    }

    public void setClientList(List<String> clientList) {
        this.clientList = clientList;
    }

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId;
    }

    public String getSpPrice() {
        return spPrice;
    }

    public void setSpPrice(String spPrice) {
        this.spPrice = spPrice;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getChangePriceDate() {
        return changePriceDate;
    }

    public void setChangePriceDate(Date changePriceDate) {
        this.changePriceDate = changePriceDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
