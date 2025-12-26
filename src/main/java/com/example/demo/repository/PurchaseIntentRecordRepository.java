package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.repository.PurchaseIntentRepository;
import com.example.demo.service.PurchaseIntentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseIntentServiceImpl implements PurchaseIntentService {
    
    private final PurchaseIntentRepository purchaseIntentRepository;
    
    public PurchaseIntentServiceImpl(PurchaseIntentRepository purchaseIntentRepository) {
        this.purchaseIntentRepository = purchaseIntentRepository;
    }
    
    @Override
    public PurchaseIntentRecord createIntent(PurchaseIntentRecord purchaseIntent) {
        return purchaseIntentRepository.save(purchaseIntent);
    }
    
    @Override
    public List<PurchaseIntentRecord> getAllIntents() {
        return purchaseIntentRepository.findAll();
    }
}