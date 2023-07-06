package dqualizer.research.dqapi.models.dam;

import lombok.Data;

import java.util.List;

@Data
public class Endpoint {
    private String field;
    private String operation;
    private List<PathVariable> path_variables;
    private List<Object> url_parameter;
    private List<RequestParameter> request_parameter;
    private List<Payload> payload;
    private List<Response> responses;
}
