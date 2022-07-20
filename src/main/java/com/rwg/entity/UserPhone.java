package com.rwg.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author renwg
 * @date 2022/4/29
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPhone {

    private int id;

    private Integer userId;

    private String phone;
}
