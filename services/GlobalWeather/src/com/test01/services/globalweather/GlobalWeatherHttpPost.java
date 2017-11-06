/*Generated by WaveMaker Studio*/
package com.test01.services.globalweather;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2017-11-03T06:04:54.609Z
 * Generated source version: 2.7.11
 * 
 */
@WebService(targetNamespace = "http://www.webserviceX.NET", name = "GlobalWeatherHttpPost")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface GlobalWeatherHttpPost {

    /**
     * Get all major cities by country name(full / part).
     */
    @WebMethod(operationName = "GetCitiesByCountry")
    @WebResult(name = "string", targetNamespace = "http://www.webserviceX.NET", partName = "Body")
    public java.lang.String getCitiesByCountry(
        @WebParam(partName = "CountryName", name = "CountryName", targetNamespace = "")
        java.lang.String countryName
    );

    /**
     * Get weather report for all major cities around the world.
     */
    @WebMethod(operationName = "GetWeather")
    @WebResult(name = "string", targetNamespace = "http://www.webserviceX.NET", partName = "Body")
    public java.lang.String getWeather(
        @WebParam(partName = "CityName", name = "CityName", targetNamespace = "")
        java.lang.String cityName,
        @WebParam(partName = "CountryName", name = "CountryName", targetNamespace = "")
        java.lang.String countryName
    );
}
