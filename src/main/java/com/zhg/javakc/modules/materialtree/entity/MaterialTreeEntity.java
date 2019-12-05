package com.zhg.javakc.modules.materialtree.entity;

import com.zhg.javakc.base.entity.BaseEntity;


public class MaterialTreeEntity extends BaseEntity<MaterialTreeEntity> {

    private String cMaterialId;
    private String cMaterialName;
    private String cMaterialLevel;
    private String cMaterialPid;
    private String cMaterialOpen;
    private String cMaterialOrder;

    public String getcMaterialId() {
        return cMaterialId;
    }

    public void setcMaterialId(String cMaterialId) {
        this.cMaterialId = cMaterialId;
    }

    public String getcMaterialName() {
        return cMaterialName;
    }

    public void setcMaterialName(String cMaterialName) {
        this.cMaterialName = cMaterialName;
    }

    public String getcMaterialLevel() {
        return cMaterialLevel;
    }

    public void setcMaterialLevel(String cMaterialLevel) {
        this.cMaterialLevel = cMaterialLevel;
    }

    public String getcMaterialPid() {
        return cMaterialPid;
    }

    public void setcMaterialPid(String cMaterialPid) {
        this.cMaterialPid = cMaterialPid;
    }

    public String getcMaterialOpen() {
        return cMaterialOpen;
    }

    public void setcMaterialOpen(String cMaterialOpen) {
        this.cMaterialOpen = cMaterialOpen;
    }

    public String getcMaterialOrder() {
        return cMaterialOrder;
    }

    public void setcMaterialOrder(String cMaterialOrder) {
        this.cMaterialOrder = cMaterialOrder;
    }
}
