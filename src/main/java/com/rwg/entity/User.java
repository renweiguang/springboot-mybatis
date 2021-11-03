package com.rwg.entity;

import com.alibaba.fastjson.annotation.JSONField;
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
    private String name;

    @JSONField(name = "Pwd")
    private String pwd;
}
