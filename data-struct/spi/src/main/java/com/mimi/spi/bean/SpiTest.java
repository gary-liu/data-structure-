package com.mimi.spi.bean;

import java.util.ServiceLoader;

/**
 * create by gary 2020/5/3
 * 技术交流请加QQ:498982703
 */
public class SpiTest {

    public static void main(String[] args) {
        getCicadaBeanFactory();
    }

    public static CicadaBeanFactory getCicadaBeanFactory() {
        ServiceLoader<CicadaBeanFactory> load = ServiceLoader.load(CicadaBeanFactory.class);
        if (load.iterator().hasNext()) {
            return load.iterator().next();
        }
        return new CicadaBeanFactory() {
            @Override
            public void register(Object object) {
                System.out.println("bean register");

            }

            @Override
            public Object getBean(String name) throws Exception {
                return null;
            }

            @Override
            public <T> T getBean(Class<T> clasz) throws Exception {
                return null;
            }

            @Override
            public void releaseBean() {

            }
        };
    }
}
