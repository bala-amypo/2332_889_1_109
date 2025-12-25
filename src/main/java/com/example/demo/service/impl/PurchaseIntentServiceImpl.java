package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.repository.PurchaseIntentRecordRepository;
import com.example.demo.service.PurchaseIntentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseIntentServiceImpl implements PurchaseIntentService {

    private final PurchaseIntentRecordRepository purchaseRepo;

    public PurchaseIntentServiceImpl(PurchaseIntentRecordRepository purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    @Override
    public List<PurchaseIntentRecord> getIntentsByUser(Long userId) {
        return purchaseRepo.findByUserId(userId); // Repository must have this method
    }

    @Override
    public PurchaseIntentRecord getIntentById(Long id) {
        return purchaseRepo.findById(id).orElse(null);
    }

    @Override
    public PurchaseIntentRecord saveIntent(PurchaseIntentRecord intent) {
        return purchaseRepo.save(intent);
    }
}
