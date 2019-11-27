package com.zhg.javakc.modules.query.groups.controller;

import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.modules.mdm.supplier.entity.SupplierEntity;
import com.zhg.javakc.modules.query.groups.entity.GroupsEntity;
import com.zhg.javakc.modules.query.groups.service.GroupsService;
import com.zhg.javakc.modules.system.menu.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("groups")
public class GroupsController {

    @Autowired
    private GroupsService groupsService;

    @RequestMapping("query")
    @ResponseBody
    public List<Map<String,Object>> queryAllGroups(){
        List<Map<String,Object>> list=groupsService.queryAllGroups();
        return list;
    }
	
	@RequestMapping("save")
    public String save(GroupsEntity groupsEntity){
        groupsEntity.setGroupId(CommonUtil.uuid());
        groupsService.save(groupsEntity);
        return "query/groups/list";
    }

    @RequestMapping("delete")
    public String delete(String groupId){
        //得到当前groupId下的所有子节点数据
        List<Map<String,Object>> list=groupsService.queryByGroupId(groupId);
        if(null!=list&&list.size()>0){
            for(Map<String,Object> map:list){
                delete(map.get("id").toString());
            }
            groupsService.deleteGroups(groupId);
        }else{
            //删除当前节点
            groupsService.deleteGroups(groupId);
        }
        return "query/groups/list";
    }

    @RequestMapping("view")
    public String view(String groupId,ModelMap modelMap){
        modelMap.put("entity",groupsService.get(groupId));
        return "query/groups/update";
    }

    @RequestMapping("update")
    public String update(GroupsEntity entity)
    {
        System.out.println(entity);
        groupsService.update(entity);
        return "query/groups/list";
    }
}
