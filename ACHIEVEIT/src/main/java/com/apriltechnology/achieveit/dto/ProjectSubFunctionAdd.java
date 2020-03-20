package com.apriltechnology.achieveit.dto;

import javax.validation.constraints.NotNull;

/**
 * @Descriptiom 项目子功能信息添加传输层
 * @Author fjm
 * @Date 2020/3/20
 */
public class ProjectSubFunctionAdd {

    @NotNull(message = "关联功能id为空")
    private Long funcId;

    private String functionName;

    private String personCharge;

    public Long getFuncId() {
        return funcId;
    }

    public void setFuncId(Long funcId) {
        this.funcId = funcId;
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
