package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.webservice.mine.GetCurrencyRequest;
import com.webservice.mine.GetCurrencyResponse;

@Endpoint
public class CurrencyEndPoint {
	private static final String NAMESPACE_URI = "http://www.webservice.com/mine";
	 
    private CountryRepository countryRepository;
 
    @Autowired
    public void CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
	 @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCurrencyRequest")
	    @ResponsePayload
	    public GetCurrencyResponse getCurrency(@RequestPayload GetCurrencyRequest request) {
	    	GetCurrencyResponse response = new GetCurrencyResponse();
	        response.setCurrency(countryRepository.getCurrency(request.getName()));
	        return response;
	    }

}
