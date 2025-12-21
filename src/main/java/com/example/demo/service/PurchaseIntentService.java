package com.example.demo.service;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PurchaseIntentRecordRepository;

import java.util.List;

public class PurchaseIntentService {

    private final PurchaseIntentRecordRepository repository;

    public PurchaseIntentService(PurchaseIntentRecordRepository repository) {
        this.repository = repository;
    }

    public PurchaseIntentRecord createIntent(PurchaseIntentRecord intent) {
        if (intent.getAmount() == null || intent.getAmount() <= 0) {
            throw new BadRequestException("Amount must be > 0");
        }
        return repository.save(intent);
    }

    public List<PurchaseIntentRecord> getIntentsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public PurchaseIntentRecord getIntentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Intent not found"));
    }

    public List<PurchaseIntentRecord> getAllIntents() {
        return repository.findAll();
    }
}
