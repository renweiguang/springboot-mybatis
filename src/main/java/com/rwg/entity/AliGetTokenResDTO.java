package com.rwg.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AliGetTokenResDTO
{
    private boolean success;

    private String code;

    private String message;

    private String requestId;

    private JSONObject data;
}
