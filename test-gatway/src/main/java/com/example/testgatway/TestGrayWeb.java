package com.example.testgatway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zbm
 * @date 2024/3/815:10
 */
@RestController
public class TestGrayWeb {

    @Autowired
    @Qualifier("newRestTemplate")
    private RestTemplate restTemplate;
    @GetMapping("/testGray")
    public String testGray(){
        MultiValueMap<String, String> headers=new HttpHeaders();
        headers.add("version","2");
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> exchange = restTemplate.exchange("http://test-gray/api/v1/test", HttpMethod.GET, requestEntity, String.class);
        return exchange.getBody();
    }

}
