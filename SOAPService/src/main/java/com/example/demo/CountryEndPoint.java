package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.webservice.mine.GetCountryRequest;
import com.webservice.mine.GetCountryResponse;
import com.webservice.mine.GetCurrencyResponse;


//SOAP web service endpoint class will handle all the incoming requests for the service.
//It will initiate the processing and will send the response back

/*
 * @Endpoint – registers the class with Spring WS as a Web Service Endpoint
   @PayloadRoot – defines the handler method according to the namespace and localPart attributes
   @ResponsePayload – indicates that this method returns a value to be mapped to the response payload
   @RequestPayload – indicates that this method accepts a parameter to be mapped from the incoming request
 */

//NAMESPACE_URI must be same as target namespace mentioned in xsd
@Endpoint
public class CountryEndPoint {
	private static final String NAMESPACE_URI = "http://www.webservice.com/mine";
	 
    private CountryRepository countryRepository;
 
    @Autowired
    public void CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
 
    //localPart value should be the request element name mentioned in xsd
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }      
}