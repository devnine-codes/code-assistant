package com.devnine.codeassistant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {
    private String status;
    private String message;
    private List<String> violations;
}
