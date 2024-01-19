package io.github.dqualizer.dqapi.models.dst;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Connection {
    private String id;
    private String annotation;

}
