package com.rwg.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntityQo {
    /**
     * 标题
     */
    private String title;
    /**
     * 页码
     */
    @Builder.Default
    private Integer pageNo = 1;
    /**
     * 页面大小
     */
    @Builder.Default
    private Integer pageSize = 10;

}
