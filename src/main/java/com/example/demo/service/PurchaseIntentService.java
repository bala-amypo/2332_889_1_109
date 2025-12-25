package com.example.demo.service;

import com.example.demo.entity.PurchaseIntentRecord;

import java.util.List;

public interface PurchaseIntentService {

    List<PurchaseIntentRecord> getIntentsByUser(Long userId);

    PurchaseIntentRecord getIntentById(Long id);

    PurchaseIntentRecord saveIntent(PurchaseIntentRecord intent);
}
