package com.example.demo.service;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CreditCardRecordRepository;

import java.util.List;

public class CreditCardService {

    private final CreditCardRecordRepository repository;

    public CreditCardService(CreditCardRecordRepository repository) {
        this.repository = repository;
    }

    public CreditCardRecord addCard(CreditCardRecord card) {
        return repository.save(card);
    }

    public CreditCardRecord updateCard(Long id, CreditCardRecord updated) {
        CreditCardRecord card = getCardById(id);

        card.setCardName(updated.getCardName());
        card.setIssuer(updated.getIssuer());
        card.setCardType(updated.getCardType());
        card.setAnnualFee(updated.getAnnualFee());
        card.setStatus(updated.getStatus());

        return repository.save(card);
    }

    public List<CreditCardRecord> getCardsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public CreditCardRecord getCardById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));
    }

    public List<CreditCardRecord> getAllCards() {
        return repository.findAll();
    }
}
