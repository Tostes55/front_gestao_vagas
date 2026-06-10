package com.gerenciador.front_gestao_vagas.modules.candidate.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ApplyJobService {

    public String execute(String token, UUID jobId){


        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);


        HttpEntity<UUID> request = new HttpEntity<>(jobId, headers);

        var result = rt.postForObject("http://localhost:8080/candidate/job/apply", request, String.class);


        System.out.println(result);

        return result;

    }
}
