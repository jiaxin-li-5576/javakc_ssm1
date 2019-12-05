package com.zhg.javakc.modules.client.controller;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.modules.client.entity.ClientEntity;
import com.zhg.javakc.modules.client.service.ClientService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequiresPermissions("client:query")
    @RequestMapping(value = "/query")
    public String query(ClientEntity entity, ModelMap model,
                         HttpServletRequest request,HttpServletResponse response)throws Exception{
        model.put("page",clientService.findClient(new Page<ClientEntity>(request,response),entity));
        model.put("entity",entity);
        return "client/list";
    }
}
