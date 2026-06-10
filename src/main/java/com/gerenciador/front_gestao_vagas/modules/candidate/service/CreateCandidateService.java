package com.gerenciador.front_gestao_vagas.modules.candidate.service;

import com.gerenciador.front_gestao_vagas.modules.candidate.dto.CreateCandidateDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CreateCandidateService {
    public void execute(CreateCandidateDTO candidate){

            RestTemplate rt = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<CreateCandidateDTO> request = new HttpEntity<>(candidate, headers);

            var result = rt.postForObject("http://localhost:8080/candidate/", request, String.class);

            System.out.println(result);

    }
}
