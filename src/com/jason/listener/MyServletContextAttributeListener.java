package com.jason.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @author：Jason
 * @date：2021/1/22 17:03
 * @email：1129847330@qq.com
 * @description:
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("MyServletContextAttributeListener attributeAdded()");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("MyServletContextAttributeListener attributeRemoved()");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("MyServletContextAttributeListener attributeReplaced()");
    }
}