package com.digitalmarketing.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "leads")
@Data
@NoArgsConstructor
public class Lead {
    @Id
    private String id;

    private String name;
    private String email;
    private String phone;
    private String serviceInterested;
    private String message;
    private Instant createdAt;
}
