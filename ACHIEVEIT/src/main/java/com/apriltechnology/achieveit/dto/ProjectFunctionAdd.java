package com.apriltechnology.achieveit.dto;

import javax.validation.constraints.NotNull;

/**
 * @Descriptiom 项目功能信息添加传输层
 * @Author fjm
 * @Date 2020/3/20
 */
public class ProjectFunctionAdd {

    @NotNull(message = "关联项目id为空")
    private Long projectId;

    private String functionName;

    private String personCharge;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getPersonCharge() {
        return personCharge;
    }

    public void setPersonCharge(String personCharge) {
        this.personCharge = personCharge;
    }
}
