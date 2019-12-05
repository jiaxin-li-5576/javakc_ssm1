package com.zhg.javakc.modules.client.entity;

import com.zhg.javakc.base.entity.BaseEntity;

public class ClientEntity extends BaseEntity<ClientEntity> {

//    客户主键ID，编码
    private String clientId;
//    名称
    private String clientName;
//    缩写
    private String clientSuoxie;
//    联系人
    private String clientContacts;
//    电话
    private Integer clientTel;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSuoxie() {
        return clientSuoxie;
    }

    public void setClientSuoxie(String clientSuoxie) {
        this.clientSuoxie = clientSuoxie;
    }

    public String getClientContacts() {
        return clientContacts;
    }

    public void setClientContacts(String clientContacts) {
        this.clientContacts = clientContacts;
    }

    public Integer getClientTel() {
        return clientTel;
    }

    public void setClientTel(Integer clientTel) {
        this.clientTel = clientTel;
    }
}
