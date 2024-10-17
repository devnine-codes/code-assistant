package com.devnine.codeassistant.service;

import com.devnine.codeassistant.util.JavaKeywords;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeAnalyzerService {

    private static final Logger logger = LoggerFactory.getLogger(CodeAnalyzerService.class);

    public List<String> analyzeCode(String javaCode) {
        List<String> violations = new ArrayList<>();

        try {
            logger.info("Starting analysis of the code");

            // Check for incorrect usage of Java keywords
            checkJavaKeywords(javaCode, violations);

        } catch (Exception e) {
            logger.error("Exception occurred while parsing code: ", e);
            violations.add("Error parsing code: " + e.getMessage());
        }

        return violations;
    }

    // Method to check if any Java keywords are incorrectly capitalized
    private void checkJavaKeywords(String code, List<String> violations) {
        // Split the code into words and check each word against the Java keyword list
        String[] words = code.split("\\s+");
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            if (JavaKeywords.isKeyword(lowerCaseWord) && !StringUtils.equals(word, lowerCaseWord)) {
                violations.add("Keyword '" + word + "' should be '" + lowerCaseWord + "'");
            }
        }
    }
}
