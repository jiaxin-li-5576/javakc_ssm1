package com.zhg.javakc.modules.query.groups.service;

import com.zhg.javakc.base.service.BaseService;
import com.zhg.javakc.modules.org.tree.entity.OrgtreeEntity;
import com.zhg.javakc.modules.query.groups.dao.GroupsDao;
import com.zhg.javakc.modules.query.groups.entity.GroupsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupsService extends BaseService<GroupsDao,GroupsEntity> {

    @Autowired
    private GroupsDao groupsDao;

    public List<Map<String,Object>> queryAllGroups(){
        List<Map<String,Object>> list=groupsDao.queryAllGroups();
        return list;
//        //查询所有结构树数据
//        List<GroupsEntity> list = dao.findList(null);
//        //封装数据到Map中, 以方便转JSON
//        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
//        list.forEach( entity -> {
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("id", entity.getGroupId());
//            map.put("name", entity.getGroupName());
//            map.put("pId", entity.getGroupPid());
//            map.put("lev", entity.getGroupLevel());
//
//            mapList.add(map);
//        });
//        return mapList;
    }

    public List<Map<String,Object>> queryByGroupId(String groupId){

        return groupsDao.queryByGroupId(groupId);
    }

    public void deleteGroups(String groupId){
        groupsDao.deleteGroups(groupId);
    }
}
