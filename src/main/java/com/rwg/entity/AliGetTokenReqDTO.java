package com.rwg.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AliGetTokenReqDTO
{

    private String userName;

    private String passWord;

    private String clientId;

    private String clientSecret;


}
