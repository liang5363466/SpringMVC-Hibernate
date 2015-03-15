package com.ndsoft.cms.api;
import java.util.HashMap;  
import java.util.Map;  
import java.util.Properties;  
  

import org.springframework.beans.BeansException;  
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;  
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;  
  
/**
 * 配置文件帮助类，用户获取配置文件内容信息
 * @author LiangZheHao
 *
 */
public class PropertyConfigHelper extends PropertyPlaceholderConfigurer {  
    private static Map<String, Object> ctxPropertiesMap;  
    @Override  
    protected void processProperties(ConfigurableListableBeanFactory beanFactory,  
            Properties props)throws BeansException {  
        super.processProperties(beanFactory, props);  
        ctxPropertiesMap = new HashMap<String, Object>();  
        for (Object key : props.keySet()) {  
            String keyStr = key.toString();  
            String value = props.getProperty(keyStr);  
            ctxPropertiesMap.put(keyStr, value);  
        }  
    }  
    public String getContextProperty(String name) {  
        return (String) ctxPropertiesMap.get(name);  
    }  
}  