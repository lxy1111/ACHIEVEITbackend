package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.dto.UserLoginInfo;
import com.apriltechnology.achieveit.service.LoginService;
import com.apriltechnology.achieveit.util.JWTUtil;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 登录控制层
 * @Author fjm
 * @Date 2020/3/9
 */

@Controller
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/LogOn")
    @ResponseBody
    public Response logOn(@Valid @RequestBody UserLoginInfo userLoginInfo, BindingResult results){

        if(results.hasErrors()){
            return Response.createError("1",results.getFieldError().getDefaultMessage());
        }

        Response response = new Response();
        Pair<Boolean,String> result = loginService.logOn(userLoginInfo.getUsername(),userLoginInfo.getPassword());
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            String token = JWTUtil.sign(userLoginInfo.getUsername(),userLoginInfo.getPassword());
            Map<String,String> map = new HashMap<>();
            map.put("token",token);
            response.setData(map);
            return response;
        }else{
            response.setCode("1");
            response.setMsg(result.getValue());
            return response;
        }

    }

}