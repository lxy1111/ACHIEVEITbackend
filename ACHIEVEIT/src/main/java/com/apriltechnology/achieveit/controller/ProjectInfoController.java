package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.ProjectInfoSearch;
import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.entity.ProjectInfo;
import com.apriltechnology.achieveit.exception.BatchDeleteException;
import com.apriltechnology.achieveit.service.ProjectInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 项目信息controller层
 * @Author fjm
 * @Date 2020/3/17
 */
@Controller
@RequestMapping("/ProjectInfo")
@Api(tags = "项目信息接口")
@Slf4j
public class ProjectInfoController {

    @Autowired
    private ProjectInfoService projectInfoService;

    @RequestMapping("/Search")
    @ResponseBody
    @ApiOperation("查询项目信息")
    Response projectInfoSearch(@RequestBody ProjectInfoSearch projectInfoSearch){

        if(null == projectInfoSearch.getPageNum()){
            projectInfoSearch.setPageNum(0);
        }

        if(null == projectInfoSearch.getPageSize()){
            projectInfoSearch.setPageSize(10);
        }

        Response response = new Response();

        Integer count = projectInfoService.getProjectInfoCount(projectInfoSearch);

        List<ProjectInfo> projectInfos = projectInfoService.getProjectInfo(projectInfoSearch);
        Map<String,List<ProjectInfo>> map = new HashMap<>();
        map.put("infoList",projectInfos);

        response.setCode("0");
        response.setMsg("查询成功");
        response.setCount(count);
        response.setData(map);

        return response;
    }

    @RequestMapping("/Edit")
    @ResponseBody
    @ApiOperation("更新项目信息")
    Response editProjectInfo(@RequestBody ProjectInfoSearch projectInfoSearch){

        Response response = new Response();

        Pair<Boolean,String> result = projectInfoService.editProjectInfo(projectInfoSearch);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else{
            return Response.createError("`1",result.getValue());
        }
    }

    @RequestMapping("/Delete")
    @ResponseBody
    @ApiOperation("删除项目信息")
    Response deleteProjectInfo(@RequestParam("ids[]") List<Long> ids){

        Response response = new Response();

        try {
            Pair<Boolean,String> result = projectInfoService.deleteProjectInfo(ids);
            if(result.getKey()){
                response.setCode("0");
                response.setMsg(result.getValue());
                return response;
            }else{
                response.setCode("1");
                response.setMsg(result.getValue());
                return response;
            }
        } catch (BatchDeleteException e) {
            log.error("deleteProjectInfo", ExceptionUtils.getStackTrace(e));
            response.setCode("1");
            response.setMsg(e.getMessage());
            return response;
        }

    }

}
