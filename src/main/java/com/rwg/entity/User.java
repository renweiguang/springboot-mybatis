package com.rwg.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User
{
    private int id;

    @JSONField(name = "Name")
    @JsonProperty("Name")
    private String name;

    @JSONField(name = "Pwd")
    @JsonProperty("Pwd")
    private String pwd;

    private String phone;

    private Integer userId;
}
