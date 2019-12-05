package com.zhg.javakc.modules.materialtree.service;

import com.zhg.javakc.base.service.BaseService;
import com.zhg.javakc.modules.materialtree.dao.MaterialTreeDao;
import com.zhg.javakc.modules.materialtree.entity.MaterialTreeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class MaterialTreeService extends BaseService<MaterialTreeDao, MaterialTreeEntity> {

    @Autowired
    MaterialTreeDao materialTreeDao;

    public List<Map<String,Object>> queryAllcm(){
        return materialTreeDao.queryAllcm();
    }
}
