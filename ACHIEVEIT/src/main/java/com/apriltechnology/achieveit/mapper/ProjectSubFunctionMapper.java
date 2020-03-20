package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.dto.ProjectSubFunctionAdd;
import com.apriltechnology.achieveit.dto.ProjectSubFunctionEdit;
import org.springframework.stereotype.Repository;

/**
 * @Description 项目子功能mapper接口
 * @Author fjm
 * @Date 2020/3/20
 */
@Repository
public interface ProjectSubFunctionMapper {

    /**
     * 添加项目子功能信息
     * @param projectSubFunctionAdd
     * @return
     */
    int projectSubFunctionAdd(ProjectSubFunctionAdd projectSubFunctionAdd);

    /**
     * 编辑项目子功能信息
     * @param projectSubFunctionEdit
     * @return
     */
    int projectSubFunctionEdit(ProjectSubFunctionEdit projectSubFunctionEdit);

    /**
     * 删除项目子功能信息
     * @param id
     * @return
     */
    int projectSubFunctionDelete(Long id);
}
