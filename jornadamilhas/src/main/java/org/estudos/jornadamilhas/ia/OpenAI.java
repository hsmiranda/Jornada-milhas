package org.estudos.jornadamilhas.ia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenAI {

    @JsonProperty("model")
    private String model;

    @JsonProperty("temperature")
    private BigDecimal temperature;

    @JsonProperty("messages")
    private OpenAIMessage[] openAIMessage;

}
