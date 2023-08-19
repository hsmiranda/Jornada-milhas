package org.estudos.jornadamilhas.infra.ia;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.HashMap;
import java.util.Map;


@ApplicationScoped
public class ChatGPTUtils {

    @Inject
    @ConfigProperty(name = "openai.secret-key", defaultValue = "Not setting api secret")
    String openiaSecret;
    private Client client;
    private WebTarget textCompletaionsTarget;

    @PostConstruct
    void InitClient() {
        this.client = ClientBuilder.newClient();
        this.textCompletaionsTarget = client.target("https://api.openai.com/v1/chat/completions");
    }

    @PreDestroy
    void close() {
        this.client.close();
    }

    public String generateText(String prompt) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        map.put("model", "gpt-3.5-turbo");
        map.put("prompt", prompt);
        map.put("max_tokens", 64);
        String json = mapper.writeValueAsString(map);

        Response response = textCompletaionsTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + openiaSecret)
                .post(Entity.json(json));

        //TODO Continue...

        return null
    }


}
