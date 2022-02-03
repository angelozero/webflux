package angelozero.webfluxapp.controller.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataRestResponse {

    @JsonProperty("identificador")
    private String id;

    @JsonProperty("nome")
    private String name;
}
