package com.devnine.codeassistant.controller;

import com.devnine.codeassistant.dto.ApiResponse;
import com.devnine.codeassistant.dto.JavaCodeRequest;
import com.devnine.codeassistant.service.CodeAnalyzerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analyze")
public class CodeAnalysisController {

    private final CodeAnalyzerService codeAnalyzerService;
    private static final Logger logger = LoggerFactory.getLogger(CodeAnalysisController.class);

    public CodeAnalysisController(CodeAnalyzerService codeAnalyzerService) {
        this.codeAnalyzerService = codeAnalyzerService;
    }

    @PostMapping("/java")
    public ResponseEntity<ApiResponse> analyzeJavaCode(@RequestBody JavaCodeRequest request) {
        logger.info("Received request to analyze Java code");
        logger.info("Code to analyze: " + request.getJavaCode());

        // Analyze the provided Java code
        List<String> result = codeAnalyzerService.analyzeCode(request.getJavaCode());

        if (result.isEmpty()) {
            logger.info("No violations found");
            return ResponseEntity.ok(new ApiResponse("success", "No violations found", result));
        } else {
            logger.info("Violations found: " + result);
            return ResponseEntity.ok(new ApiResponse("fail", "Violations found", result));
        }
    }
}
