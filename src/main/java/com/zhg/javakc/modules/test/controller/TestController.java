package com.zhg.javakc.modules.test.controller;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.modules.test.entity.TestEntity;
import com.zhg.javakc.modules.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("test")
public class TestController {
//111111111111111111111111111111111111111
    @Autowired
    private TestService testService;

    @RequestMapping("query")
    public ModelAndView query(TestEntity testEntity, HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView("test/list");
        Page<TestEntity> page=testService.queryTest(testEntity,new Page<TestEntity>(request,response));
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    @RequestMapping("save")
    public String save(TestEntity testEntity){
        //设置ID
        testEntity.setTestId(CommonUtil.uuid());
        testService.save(testEntity);
        return "redirect:query.do";
    }

    @RequestMapping("view")
    public String view(String ids, ModelMap modelMap){
        TestEntity testEntity=testService.get(ids);
        modelMap.put("testEntity",testEntity);
        return "test/update";
    }

    @RequestMapping("update")
    public String update(TestEntity testEntity){
        testService.update(testEntity);
        return "redirect:query.do";
    }

    @RequestMapping("delete")
    public String delete(String[] ids){
        testService.delete(ids);
        return "redirect:query.do";
    }
}
