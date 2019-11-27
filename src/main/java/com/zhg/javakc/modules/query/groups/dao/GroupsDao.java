package com.zhg.javakc.modules.query.groups.dao;

import com.zhg.javakc.base.dao.BaseDao;
import com.zhg.javakc.modules.query.groups.entity.GroupsEntity;

import java.util.List;
import java.util.Map;

public interface GroupsDao extends BaseDao<GroupsEntity> {

    public List<Map<String,Object>> queryAllGroups();

    public List<Map<String,Object>> queryByGroupId(String groupId);

    public void deleteGroups(String groupId);
}
