package com.zhg.javakc.modules.salesprice.controller;


import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.modules.client.entity.ClientEntity;
import com.zhg.javakc.modules.client.service.ClientService;
import com.zhg.javakc.modules.salesprice.entity.SalesPriceEntity;
import com.zhg.javakc.modules.salesprice.service.SalesPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "salesprice")
public class SalesPriceController {

    @Autowired
    private SalesPriceService salesPriceService;
    
    @Autowired
    private ClientService clientService;


    /**
     * 查询页面
     * @param entity
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="query")
    public String query(SalesPriceEntity entity, ModelMap model,
                        HttpServletRequest request, HttpServletResponse response)throws Exception {

        model.put("page",salesPriceService.findSalesPrice(new Page<SalesPriceEntity>(request,response),entity));
        model.put("entiry",entity);
        return "salesprice/list";

    }


    /**
     * 跳转到查询页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="numquery/{id}")
    public String query(@PathVariable String id, ModelMap model) {
        model.put("entiry",salesPriceService.get(id));
        return "salesprice/numquery";

    }

//    @RequestMapping(value = "numquery")
////    public String numquery(SalesPriceEntity entity){
////
////        salesPriceService.query(entity);
////        return "redirect:/salesprice/query.do";
////
////    }

    /**
     * 添加
     * @param entity
     * @param sprice
     * @return
     */
    @RequestMapping(value="/create")
    public String create(SalesPriceEntity entity, String[] sprice)
    {
       salesPriceService.save(entity, sprice);
        return "redirect:/salesprice/query.do";
    }

    /**
     * 销售表格的添加方法
     * @param entity 实体对象
     * @return
     */
    @RequestMapping(value="/add")
    public String add(ClientEntity entity, ModelMap model)
    {
        model.put("page", clientService.findList(entity));
        return "salesprice/list";
    }

    @RequestMapping(value="/listParent")
    public String createParent(ClientEntity entity, ModelMap model) throws Exception
    {
        model.put("page", clientService.findList(entity));
        return "salesprice/list-parent";
    }
    /**
     * 跳转到修改页面
     * @param id
     * @param model
     * @return
     */

    @RequestMapping(value = "view/{id}")
    public String view (@PathVariable String id, ModelMap model){

        model.put("entity",salesPriceService.get(id));
        return "salesprice/update";
    }


    /**
     * 修改
     * @param entity
     * @return
     */

    @RequestMapping(value = "update")
    public String update(SalesPriceEntity entity){

        salesPriceService.update(entity);
        return "redirect:/salesprice/query.do";

    }

    @RequestMapping(value = "delete")
    public String delete(String[] ids){

        salesPriceService.delete(ids);

        return  "redirect:query.do";
    }


}
