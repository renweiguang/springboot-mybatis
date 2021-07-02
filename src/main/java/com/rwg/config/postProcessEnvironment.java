package com.rwg.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class postProcessEnvironment implements EnvironmentPostProcessor
{
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application)
    {
        String path = "C:\\Users\\rwg\\Desktop\\axis_cfg.properties";
        File file  = new File(path);
        if (!file.exists())
        {
            System.out.println("配置文件 axis_cfg.properties 不存在！");
            return;
        }
        Properties prop = new Properties();
        try(InputStream is = new FileInputStream(file))
        {
            prop.load(is);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addFirst(new PropertiesPropertySource("Config", prop));
    }
}
