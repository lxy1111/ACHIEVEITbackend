package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.dto.ProjectInfoSearch;
import com.apriltechnology.achieveit.entity.ProjectInfo;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description ProjectInfo类mapper接口
 * @Author fjm
 * @Date 2020/3/17
 */
@Repository
public interface ProjectInfoMapper {


    /**
     * 查询项目
     * @return
     */
    List<ProjectInfo> getProjectInfoList(Long id, String projectName, String customerInfo, String leader, String milepost, String projectFunction,
                                         String technology, String businessArea, Timestamp scheduleTime, Timestamp deliveryTime, Integer pageFirst, Integer pageLast);

    /**
     * 查询项目数量
     * @return
     */
    Integer getProjectInfoCount(Long id, String projectName, String customerInfo, String leader, String milepost, String projectFunction,
                                String technology, String businessArea, Timestamp scheduleTime, Timestamp deliveryTime);


    /**
     * 更新项目信息
     * @param projectInfoSearch
     * @return
     */
    int updateProjectInfo(ProjectInfoSearch projectInfoSearch);

    /**
     * 删除项目
     * @param ids
     * @return
     */
    int deleteProjectInfo(List<Long> ids);

}
