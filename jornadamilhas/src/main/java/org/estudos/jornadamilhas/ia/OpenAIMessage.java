package org.estudos.jornadamilhas.ia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenAIMessage {

    @JsonProperty("role")
    private String role;

    @JsonProperty("content")
    private String content;


}
