package com.example.demo.service;

import com.example.demo.entity.PurchaseIntentRecord;
import java.util.List;

public interface PurchaseIntentService {
    PurchaseIntentRecord createIntent(PurchaseIntentRecord purchaseIntent);
    List<PurchaseIntentRecord> getAllIntents();
    List<PurchaseIntentRecord> getIntentsByUser(Long userId); // Add this method
    PurchaseIntentRecord getIntentById(Long id); // Add this method
}