package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.ProjectSubFunctionAdd;
import com.apriltechnology.achieveit.dto.ProjectSubFunctionEdit;
import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.service.ProjectSubFunctionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ProjectSubFunction")
@Api(tags = "项目子功能接口")
@Slf4j
public class ProjectSubFunctionController {

    @Autowired
    private ProjectSubFunctionService projectSubFunctionService;


    @RequestMapping("/SubEdit")
    @ResponseBody
    @ApiOperation("编辑项目子功能信息")
    public Response editProjectSubFunction(@RequestBody ProjectSubFunctionEdit projectSubFunctionEdit, BindingResult results){
        if(results.hasErrors()){
            log.error("editProjectSubFunction bindingResult",results.getFieldError().getField());
            return Response.createError("1",results.getFieldError().getField());
        }

        Response response = new Response();

        Pair<Boolean,String> result = projectSubFunctionService.projectSubFunctionEdit(projectSubFunctionEdit);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @RequestMapping("/SubDelete")
    @ResponseBody
    @ApiOperation("删除项目子功能信息")
    public Response deleteProjectSubFunction(@RequestParam(value = "id")Long id){


        if(null == id || id <= 0){
            return Response.createError("1","id不能为空或者小于等于0");
        }

        Response response = new Response();

        Pair<Boolean,String> result = projectSubFunctionService.projectSubFunctionDelete(id);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @RequestMapping("/SubAdd")
    @ResponseBody
    @ApiOperation("添加项目子功能信息")
    public Response addProjectSubFunction(@RequestBody ProjectSubFunctionAdd projectSubFunctionAdd, BindingResult results){

        if(results.hasErrors()){
            log.error("editProjectSubFunction bindingResult",results.getFieldError().getField());
            return Response.createError("1",results.getFieldError().getField());
        }

        Response response = new Response();

        Pair<Boolean,String> result = projectSubFunctionService.projectSubFunctionAdd(projectSubFunctionAdd);

        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }

    }
}
