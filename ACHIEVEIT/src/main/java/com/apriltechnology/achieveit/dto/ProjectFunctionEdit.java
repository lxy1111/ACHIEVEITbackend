package com.apriltechnology.achieveit.dto;


import javax.validation.constraints.NotNull;

/**
 * @Descriptiom 项目功能编辑信息传输层
 * @Author fjm
 * @Date 2020/3/20
 */
public class ProjectFunctionEdit {

    @NotNull(message = "id为空")
    private Long id;

    private String functionName;

    private String personCharge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
