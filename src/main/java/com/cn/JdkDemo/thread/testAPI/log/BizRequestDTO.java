package com.cn.JdkDemo.thread.testAPI.log;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 类名: BizRequestDTO
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2021-12-15 14:23
 **/
@Data
public class BizRequestDTO {

    private Long id;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作人id
     */
    private Long accountId;
    /**
     * 组织机构名称
     */
    private String orgName;
    /**
     * 组织机构id
     */
    private String orgId;
    /**
     * 操作时间
     */
    private LocalDateTime operateTime;
    /**
     * 操作类型
     */
    private String operateType;
    /**
     * 应用名称
     */
    private String appClient;

    /**
     * 功能模块
     */
    private String appModule;

    /**
     * 失败原因代码
     */
    private String errorCode;

    /**
     * 日志内容
     */
    private String logContent;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 功能描述:请求结果
     **/
    private Integer reqResult;

}

