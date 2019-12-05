package com.zhg.javakc.modules.salesprice.dao;

import com.zhg.javakc.base.dao.BaseDao;
import com.zhg.javakc.base.dao.MyBatisDao;
import com.zhg.javakc.modules.salesprice.entity.SalesPriceEntity;

import java.util.Map;


@MyBatisDao
public interface SalesPriceDao extends BaseDao<SalesPriceEntity> {


    public int insert(SalesPriceEntity entity);

    public void insertRelation(Map<String, Object> spclient);

    public void deleteRelation(String spId);

}
