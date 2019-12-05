package com.zhg.javakc.modules.salesprice.service;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.service.BaseService;
import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.modules.salesprice.dao.SalesPriceDao;
import com.zhg.javakc.modules.salesprice.entity.SalesPriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class SalesPriceService extends BaseService<SalesPriceDao, SalesPriceEntity> {

    @Autowired
    private SalesPriceDao salesPriceDao;

    public Page<SalesPriceEntity> findSalesPrice(Page<SalesPriceEntity> page, SalesPriceEntity entity) {
//        设置分页参数
        entity.setPage(page);
//        执行分页查询
        page.setList(salesPriceDao.findList(entity));
        return page;
    }



    @Transactional(readOnly = false)
    public void save(SalesPriceEntity entity, String[] sprice) {
        for (int i = 0; i < sprice.length; i++) {
           entity.setSpId(CommonUtil.uuid());
            entity.setSpPrice(sprice[i]);
            salesPriceDao.insert(entity);
        }
    }


    @Transactional(readOnly = false)
    public void save1(SalesPriceEntity entity, String[] ids) {
        String spId = CommonUtil.uuid();
        entity.setSpId(spId);
        salesPriceDao.insert(entity);

        for (String clientId : ids) {
            Map<String, Object> spclient = new HashMap<String, Object>();
            spclient.put("spId", spId);
            spclient.put("clientId", clientId);
            salesPriceDao.insertRelation(spclient);
        }
    }

}