package com.mimi.spi.bean;

/**
 * create by gary 2020/5/3
 * 技术交流请加QQ:498982703
 */
public interface CicadaBeanFactory {

    void register(Object object);

    Object getBean(String name) throws Exception;

    <T> T getBean(Class<T> clasz) throws Exception;

    void releaseBean();

}
