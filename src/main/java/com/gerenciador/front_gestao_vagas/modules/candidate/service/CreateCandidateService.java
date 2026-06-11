package com.gerenciador.front_gestao_vagas.modules.candidate.service;

import com.gerenciador.front_gestao_vagas.modules.candidate.dto.CreateCandidateDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreateCandidateService {

    @Value("${host.api.gestao_vagas}")
    private String hostApiGestasoVagas;

    public void execute(CreateCandidateDTO candidate){

            RestTemplate rt = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<CreateCandidateDTO> request = new HttpEntity<>(candidate, headers);

        var url = hostApiGestasoVagas.concat("/candidate/");

        var result = rt.postForObject(url, request, String.class);

            System.out.println(result);

    }
}
