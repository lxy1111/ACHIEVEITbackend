package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.ProjectFunctionAdd;
import com.apriltechnology.achieveit.dto.ProjectFunctionEdit;
import com.apriltechnology.achieveit.dto.ProjectSubFunctionAdd;
import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.service.ProjectFunctionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 项目功能controller层
 * @Author fjm
 * @Date 2020/3/20
 */
@Controller
@RequestMapping("/ProjectFunction")
@Api(tags = "项目功能接口")
@Slf4j
public class ProjectFunctionController {

    @Autowired
    private ProjectFunctionService projectFunctionService;

    @RequestMapping("/Search")
    @ResponseBody
    @ApiOperation("查询项目功能信息")
    public Response searchProjectFunctionList(@RequestParam(value = "id") Long id){

        Response response = new Response();
        return response;

    }


    @RequestMapping("/Edit")
    @ResponseBody
    @ApiOperation("编辑项目功能信息")
    public Response editProjectFunction(@RequestBody ProjectFunctionEdit projectFunctionEdit){

        Response response = new Response();
        return response;
    }


    @RequestMapping("/Delete")
    @ResponseBody
    @ApiOperation("删除项目功能信息")
    public Response deleteProjectFunction(@RequestParam(value = "id")Long id){
        Response response = new Response();
        return response;
    }


    @RequestMapping("/Add")
    @ResponseBody
    @ApiOperation("添加项目功能信息")
    public Response addProjectFunction(@RequestBody ProjectFunctionAdd projectFunctionAdd){
        Response response = new Response();
        return response;
    }
}
