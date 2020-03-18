package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.dto.ProjectInfoSearch;
import com.apriltechnology.achieveit.entity.ProjectInfo;
import com.apriltechnology.achieveit.exception.BatchDeleteException;
import com.apriltechnology.achieveit.mapper.ProjectInfoMapper;
import com.apriltechnology.achieveit.service.ProjectInfoService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description 项目信息service实现层
 * @Author fjm
 * @Date 2020/3/17
 */
@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {

    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    @Override
    public List<ProjectInfo> getProjectInfo(ProjectInfoSearch projectInfoSearch) {

        Integer pageFirst = (projectInfoSearch.getPageNum()-1)*projectInfoSearch.getPageSize();
        Integer pageLast = pageFirst + projectInfoSearch.getPageSize();
        List<ProjectInfo> projectInfos = projectInfoMapper.getProjectInfoList(projectInfoSearch.getId(), projectInfoSearch.getProjectName(), projectInfoSearch.getCustomerInfo(),
                projectInfoSearch.getLeader(), projectInfoSearch.getMilepost(), projectInfoSearch.getProjectFunction(), projectInfoSearch.getTechnology(), projectInfoSearch.getBusinessArea(),
                projectInfoSearch.getScheduleTime(), projectInfoSearch.getDeliveryTime(),pageFirst,pageLast);

        return projectInfos;
    }

    @Override
    public Integer getProjectInfoCount(ProjectInfoSearch projectInfoSearch) {

        Integer count = projectInfoMapper.getProjectInfoCount(projectInfoSearch.getId(), projectInfoSearch.getProjectName(), projectInfoSearch.getCustomerInfo(),
                projectInfoSearch.getLeader(), projectInfoSearch.getMilepost(), projectInfoSearch.getProjectFunction(), projectInfoSearch.getTechnology(), projectInfoSearch.getBusinessArea(),
                projectInfoSearch.getScheduleTime(), projectInfoSearch.getDeliveryTime());
        return count;
    }

    @Override
    public Pair<Boolean,String> editProjectInfo(ProjectInfoSearch projectInfoSearch) {

        int result = projectInfoMapper.updateProjectInfo(projectInfoSearch);
        if(result <= 0){
            return new Pair<>(false,"更新失败！");
        }else{
            return new Pair<>(true,"更新成功！");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Pair<Boolean, String> deleteProjectInfo(List<Long> projectIds) throws BatchDeleteException{

        if(null != projectIds && projectIds.size() > 0){
            int size = projectIds.size();
            int result = projectInfoMapper.deleteProjectInfo(projectIds);
            if(result == size){
                return new Pair<>(true,"删除成功！");
            }else{
                throw new BatchDeleteException("删除失败！");
            }
        }

        return new Pair<>(false,"请选择需要删除的项目！");
    }


}
