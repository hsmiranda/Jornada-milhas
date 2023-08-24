package org.estudos.jornadamilhas.ia;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import okhttp3.*;

import java.io.IOException;
import java.math.BigDecimal;

public class OpenAIService {

    private String sendAndGetResponseFromOpenAI(OpenAI openAI) {

        String apiURL = "https://api.openai.com/v1/chat/completions";

        String apiKey = System.getenv("OPENAI_SECRET");

        Log.info(apiKey); //TODO Remover

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");

        ObjectMapper objectMapper = new ObjectMapper();
        String promptJsonFormat;

        try {
            promptJsonFormat = objectMapper.writeValueAsString(openAI);

            RequestBody requestBody = RequestBody.create(mediaType, promptJsonFormat);

            Request request = new Request.Builder()
                    .url(apiURL)
                    .post(requestBody)
                    .addHeader("Content-type", "application/json")
                    .addHeader("Authorization", "Bearer " + apiKey)
                    .build();

            Response response = client.newCall(request).execute();

            if (response.body() != null) {
                return response.body().string();
            }

        } catch (NullPointerException e) {
            Log.info("Not possible connect or send message to OpenAI API");
            return "";
        } catch (IOException e) {
            Log.error("Not possible convert Object OpenAI or OpenAIMessage to JSON Object");
            throw new RuntimeException(e);
        }

        return "";

    }

    public String generateText(String promptBase) {
        OpenAIMessage[] openAIMessage = new OpenAIMessage[]{new OpenAIMessage("user", promptBase)};
        OpenAI openAI = new OpenAI("gpt-3.5-turbo", new BigDecimal("0.7"), openAIMessage);
        return sendAndGetResponseFromOpenAI(openAI);
    }
}
