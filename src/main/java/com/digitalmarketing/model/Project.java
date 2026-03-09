package com.digitalmarketing.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projects")
@Data
@NoArgsConstructor
public class Project {
    @Id
    private String id;

    private String title;
    private String description;
    private String clientName;
    private String imageUrl;
    private String projectUrl;
}
