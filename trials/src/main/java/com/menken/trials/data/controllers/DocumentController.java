package com.menken.trials.data.controllers;

import com.menken.trials.data.entities.Document;
import com.menken.trials.data.services.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    // Handles API call to /api/documents/all and returns all documents found in db sorted by their weights (asc)
    @GetMapping("/all")
    public List<Document> fetchAll() {
        return documentService.fetchAllDocuments();
    }

    // Handles API call to /api/documents/add, where the request body is json of classifications.
    @PostMapping("/add")
    public ResponseEntity<String> addDocument(@RequestBody Map<String, BigDecimal> documents) {
        if (documentService.addDocuments(documents)) {
            return ResponseEntity.ok("Documents added successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred");
    }
}
