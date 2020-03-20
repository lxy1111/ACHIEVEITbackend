package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.dto.ProjectSubFunctionAdd;
import com.apriltechnology.achieveit.dto.ProjectSubFunctionEdit;
import javafx.util.Pair;

/**
 * @Description 项目子功能service接口类
 * @Author fjm
 * @Date 2020/3/20
 */
public interface ProjectSubFunctionService {

    /**
     * 添加项目子功能信息
     * @param projectSubFunctionAdd
     * @return
     */
    Pair<Boolean,String> projectSubFunctionAdd(ProjectSubFunctionAdd projectSubFunctionAdd);

    /**
     * 编辑项目子功能信息
     * @param projectSubFunctionEdit
     * @return
     */
    Pair<Boolean,String> projectSubFunctionEdit(ProjectSubFunctionEdit projectSubFunctionEdit);

    /**
     * 删除项目子功能信息
     * @param id
     * @return
     */
    Pair<Boolean,String> projectSubFunctionDelete(Long id);
}
