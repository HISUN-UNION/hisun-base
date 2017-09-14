package com.hisun.base.controller;

import org.quartz.CronExpression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: GlobalController.java</p>
 * <p>Description: 全局Controller</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 湖南海数互联信息技术有限公司</p>
 *
 * @author Jason
 * @version v0.1
 * @email jason4j@qq.com
 * @date 2015-11-24 09:38
 */
@Controller
@RequestMapping("")
public class GlobalController {

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String accessDenied(HttpServletRequest req, Model model) {
        return "error/accessDenied";
    }

    @RequestMapping(value="/validate/cron")
    public @ResponseBody Map<String,Object> validateCron(String cron){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("validate", CronExpression.isValidExpression(cron));
        return map;
    }
}
