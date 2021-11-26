package com.rwg.entity;

import com.rwg.annotation.MyAnno;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author rwg
 * @date 2021/11/26 19:14
 */
public class AnnoTest {

    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 获取注解信息，把注解信息的值通过反射赋值给对象

        // 1.拿到对象的class对象
        Class<AnnoUser> clazz = (Class<AnnoUser>) Class.forName("com.rwg.entity.AnnoUser");

        AnnoUser annoUser = clazz.newInstance();
        // 2. 通过反射拿到属性

        Field[] fs = clazz.getDeclaredFields();
        // 3.拿到注解
        for (Field f : fs) {

            // 先判断f是否有注解
            // 判断属性是否有MyAnnotion02注解
            //isAnnotationPresent()判断是否有注解
            if (f.isAnnotationPresent(MyAnno.class)) {

                // 通过属性使用方法：getAnnotation()获取注解
                MyAnno annotation = f.getAnnotation(MyAnno.class);
                // 4.获取注解值
                String value = annotation.name();

                // 跳过安全检测（暴力破解）
                f.setAccessible(true);

                // 5.通过反射把注解值赋值给属性
                f.set(annoUser, value);

                System.out.println(annoUser);

            }
        }
    }

}
