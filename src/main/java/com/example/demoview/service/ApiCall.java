package com.example.demoview.service;

import com.example.demoview.model.UserDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ApiCall {

    public static String BASE_URL = "http://localhost:9091";

    @Autowired
    public RestTemplate restTemplate;
    @Autowired
    public ObjectMapper objectMapper;

    public ResponseEntity<UserDetail> getUser(String endpoint, UserDetail userDetail) {
        try {
            String userDetailRequest = objectMapper.writeValueAsString(userDetail);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request =
                    new HttpEntity<String>(userDetailRequest, headers);
            ResponseEntity<UserDetail> response
                    = restTemplate.postForEntity(BASE_URL.concat(endpoint), request, UserDetail.class);
            if (response.getStatusCode().is2xxSuccessful())
                return response;
        } catch (HttpClientErrorException e) {
            log.error(">> Client Side Error: " + e.getLocalizedMessage());
            e.printStackTrace();
        } catch (HttpServerErrorException e) {
            log.error(">> Server Side Error: " + e.getLocalizedMessage());
            e.printStackTrace();
        } catch (RestClientException e) {
            log.error(">> Connection Error: " + e.getLocalizedMessage());
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            log.error(">> Error On Parsing Request Object : " + e.getLocalizedMessage());
            e.printStackTrace();
        } catch (Exception e){
            log.error(">> Something went wrong: "+ e.getLocalizedMessage());
        }
        return null;
    }

}
