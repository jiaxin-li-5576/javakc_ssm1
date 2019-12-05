package com.zhg.javakc.modules.materialtree.controller;

import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.modules.materialtree.entity.MaterialTreeEntity;
import com.zhg.javakc.modules.materialtree.service.MaterialTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/mtree")
public class MaterialTreeController {

    @Autowired
    MaterialTreeService materialTreeService;

    /**
     * 查询
     * @return
     */
    @RequestMapping(value = "queryAllcm")
    @ResponseBody
    public List<Map<String,Object>> queryAllcm(){
        List<Map<String,Object>> list=materialTreeService.queryAllcm();
        return list;
    }

    @RequestMapping("save")
    public String save(MaterialTreeEntity materialTreeEntity){

        materialTreeEntity.setcMaterialId(CommonUtil.uuid());
        materialTreeService.save(materialTreeEntity);
        return "mtree/list";
    }
}
