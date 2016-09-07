/**
 * ****************************************************************************
 *
 * Copyright (c) 2016, DRIKU Technologies and/or its affiliates. All rights
 * reserved.
 * ___________________________________________________________________________________
 *
 *
 * NOTICE: All information contained herein is, and remains the property of
 * DRIKU and its suppliers,if any. The intellectual and technical concepts
 * contained herein are proprietary to DRIKU Technologies. and its suppliers and
 * may be covered by us and Foreign Patents, patents in process, and are
 * protected by trade secret or copyright law. Dissemination of this information
 * or reproduction of this material is strictly forbidden unless prior written
 * permission is obtained from DRIKU Technologies
 */
package com.driku.configuration;

/**
 *
 * @author baldeep
 */
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
 
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
       return null;
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
       return new Class[] { WebConfiguration.class };
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}