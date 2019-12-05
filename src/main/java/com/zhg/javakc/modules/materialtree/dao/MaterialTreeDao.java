package com.zhg.javakc.modules.materialtree.dao;

import com.zhg.javakc.base.dao.BaseDao;
import com.zhg.javakc.modules.materialtree.entity.MaterialTreeEntity;

import java.util.List;
import java.util.Map;


public interface MaterialTreeDao extends BaseDao<MaterialTreeEntity> {

        public List<Map<String,Object>> queryAllcm();
}
