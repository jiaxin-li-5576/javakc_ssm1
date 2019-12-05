package com.zhg.javakc.modules.client.service;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.service.BaseService;
import com.zhg.javakc.modules.client.dao.ClientDao;
import com.zhg.javakc.modules.client.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ClientService extends BaseService<ClientDao,ClientEntity> {

    @Autowired
    private ClientDao clientDao;

    public Page<ClientEntity> findClient(Page<ClientEntity> page,ClientEntity entity) {

//        设置分页参数
        entity.setPage(page);
//        执行分页参数
        page.setList(clientDao.findList(entity));
        return page;
    }

}
