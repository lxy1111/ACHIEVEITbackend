package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.dto.ProjectSubFunctionAdd;
import com.apriltechnology.achieveit.dto.ProjectSubFunctionEdit;
import com.apriltechnology.achieveit.mapper.ProjectSubFunctionMapper;
import com.apriltechnology.achieveit.service.ProjectSubFunctionService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 项目子功能service实现类
 * @Author fjm
 * @Date 2020/3/20
 */
@Service
public class ProjectSubFunctionServiceImpl implements ProjectSubFunctionService {

    @Autowired
    private ProjectSubFunctionMapper projectSubFunctionMapper;


    @Override
    public Pair<Boolean, String> projectSubFunctionAdd(ProjectSubFunctionAdd projectSubFunctionAdd) {

        int result = projectSubFunctionMapper.projectSubFunctionAdd(projectSubFunctionAdd);
        if(result <= 0){
            return new Pair<>(false,"新增失败！");
        }

        return new Pair<>(true,"新增成功！");
    }

    @Override
    public Pair<Boolean, String> projectSubFunctionEdit(ProjectSubFunctionEdit projectSubFunctionEdit) {

        int result = projectSubFunctionMapper.projectSubFunctionEdit(projectSubFunctionEdit);
        if(result <= 0){
            return new Pair<>(false,"更新失败！");
        }

        return new Pair<>(true,"更新成功！");
    }

    @Override
    public Pair<Boolean, String> projectSubFunctionDelete(Long id) {

        int result = projectSubFunctionMapper.projectSubFunctionDelete(id);
        if(result <= 0){
            return new Pair<>(false,"删除失败！");
        }

        return new Pair<>(true,"删除成功！");
    }
}
