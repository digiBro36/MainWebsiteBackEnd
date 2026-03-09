package com.digitalmarketing.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "services")
@Data
@NoArgsConstructor
public class Service {
    @Id
    private String id;

    private String title;
    private String description;
    private Double price;
    private Boolean active;
}
