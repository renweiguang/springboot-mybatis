package com.rwg.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class XzResDTO
{
    @JSONField(name = "SFZH")
    private String SFZH;

    @JSONField(name = "YHMC")
    private String YHMC;

    @JSONField(name = "SEX")
    private String SEX;

    @JSONField(name = "JH")
    private String JH;

    @JSONField(name = "JZDM")
    private String JZDM;

    @JSONField(name = "LXDH")
    private String LXDH;

    @JSONField(name = "SJHM")
    private String SJHM;

    @JSONField(name = "GAJGJGDM")
    private String GAJGJGDM;

    @JSONField(name = "GAJGJGMC")
    private String GAJGJGMC;

    @JSONField(name = "ZXBS")
    private String ZXBS;

    @JSONField(name = "GXSJ")
    private String GXSJ;

}
