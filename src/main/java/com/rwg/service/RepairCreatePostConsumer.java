package com.rwg.service;

/**
 * @author rwg
 * @date 2021/9/7 9:43
 */
public interface RepairCreatePostConsumer {
    /**
     * 创建报修单后做什么
     *
     * @param repairId 报修单ID
     */
    void postHandler(String repairId);

    boolean support(String xxx);

}
