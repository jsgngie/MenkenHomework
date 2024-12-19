package com.menken.trials.data.services;

import com.menken.trials.data.entities.Document;
import com.menken.trials.data.repositories.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor

public class DocumentService {
    private final DocumentRepository documentRepository;

    public List<Document> fetchAllDocuments() {
        return documentRepository.findAllByOrderByWeightAsc();
    }

    /**
     * Saves all documents from passed map into db.
     * @param documents - map of documents
     * @return - true if documents were successfully added to the database, else false.
     */
    public boolean addDocuments(Map<String, BigDecimal> documents) {
        try {
            List<Document> documentList = documents.entrySet().stream().map(entry -> new Document(entry.getKey(), entry.getValue())).toList();
            documentRepository.saveAll(documentList);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
