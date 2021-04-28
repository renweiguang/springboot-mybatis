package com.rwg.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AliVerifyTokenResDTO
{
    private boolean success;

    private String code;

    private String message;

    private String requestId;
}
