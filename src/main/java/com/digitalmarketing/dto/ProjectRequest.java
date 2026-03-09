package com.digitalmarketing.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectRequest {
    @NotBlank
    private String title;

    private String description;
    private String clientName;
    private String imageUrl;
    private String projectUrl;
}
