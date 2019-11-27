package com.zhg.javakc.modules.query.groups.entity;

import com.zhg.javakc.base.entity.BaseEntity;
import lombok.Data;

@Data
public class GroupsEntity extends BaseEntity<GroupsEntity> {

    private String groupId;
    private String groupName;
    private Integer groupLevel;
    private Integer groupWeight;
    private String groupPid;
    private Integer groupOpen;

}
