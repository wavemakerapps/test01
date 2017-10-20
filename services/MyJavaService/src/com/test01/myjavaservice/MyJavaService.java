/*Copyright (c) 2017-2018 kekita.com All Rights Reserved.
 This software is the confidential and proprietary information of kekita.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with kekita.com*/
package com.test01.myjavaservice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;


import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URL;
import java.util.Arrays;
import java.net.URLClassLoader;
//import com.test01.myjavaservice.model.*;

/**
 * This is a singleton class with all its public methods exposed as REST APIs via generated controller class.
 * To avoid exposing an API for a particular public method, annotate it with @HideFromClient.
 *
 * Method names will play a major role in defining the Http Method for the generated APIs. For example, a method name
 * that starts with delete/remove, will make the API exposed as Http Method "DELETE".
 *
 * Method Parameters of type primitives (including java.lang.String) will be exposed as Query Parameters &
 * Complex Types/Objects will become part of the Request body in the generated API.
 */
@ExposeToClient
public class MyJavaService {

    private static final Logger logger = LoggerFactory.getLogger(MyJavaService.class);

    @Autowired
    private SecurityService securityService;

    /**
     * This is sample java operation that accepts an input from the caller and responds with "Hello".
     * 
     * SecurityService that is Autowired will provide access to the security context of the caller. It has methods like isAuthenticated(),
     * getUserName() and getUserId() etc which returns the information based on the caller context.
     *
     * Methods in this class can declare HttpServletRequest, HttpServletResponse as input parameters to access the
     * caller's request/response objects respectively. These parameters will be injected when request is made (during API invocation).
     */
    public String sampleJavaOperation(String name, HttpServletRequest request) {
            
        System.setProperty("webdriver.chrome.driver", "//usr//local//Tomcat//apache-tomcat-8.5.15//webapps//test//resources//drivers//chromedriver");   
        
        URL[] urLs = ((URLClassLoader) this.getClass().getClassLoader()).getURLs();
        
        logger.info("URLS LIST :: " + Arrays.toString(urLs));
        
        URL predictionsURL = this.getClass().getClassLoader().getResource("com/google/common/base/Preconditions.class");
        logger.info("predictionsURL :: {} ", predictionsURL);
        
        
        URL driverServiceURL = this.getClass().getClassLoader().getResource("org/openqa/selenium/remote/service/DriverService.class");
        logger.info("driverServiceURL :: {} ", driverServiceURL);
        
		WebDriver driver = new ChromeDriver();
	   driver.get("http://www.google.com");
        return driver.getPageSource();
    }

}
