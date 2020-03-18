package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.dto.ProjectInfoSearch;
import com.apriltechnology.achieveit.entity.ProjectInfo;
import javafx.util.Pair;

import java.util.List;

/**
 * @Description 项目信息service接口类
 * @Author fjm
 * @Date 2020/3/17
 */
public interface ProjectInfoService {

    /**
     * 根据用户输入获取项目信息
     * @param projectInfoSearch
     * @return
     */
    List<ProjectInfo> getProjectInfo(ProjectInfoSearch projectInfoSearch);

    /**
     * 查询项目数量
     * @param projectInfoSearch
     * @return
     */
    Integer getProjectInfoCount(ProjectInfoSearch projectInfoSearch);

    /**
     * 更新项目信息
     * @param projectInfoSearch
     * @return
     */
    Pair<Boolean,String> editProjectInfo(ProjectInfoSearch projectInfoSearch);

}
