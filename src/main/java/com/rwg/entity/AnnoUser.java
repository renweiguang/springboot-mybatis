package com.rwg.entity;

import com.rwg.annotation.MyAnno;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rwg
 * @date 2021/11/26 17:00
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnoUser {

    @MyAnno(name = "zhang")
    private String name;

    @MyAnno(email = "zhang@example.com")
    private String email;


    @MyAnno(name = "sayHelloWorld")
    public String sayHello() {
        return "";
    }

}
