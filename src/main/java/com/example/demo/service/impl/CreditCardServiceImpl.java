package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.repository.CreditCardRepository;
import com.example.demo.service.CreditCardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository repository;

    public CreditCardServiceImpl(CreditCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreditCardRecord addCard(CreditCardRecord card) {
        return repository.save(card);
    }

    @Override
    public CreditCardRecord getCardById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<CreditCardRecord> getAllCards() {
        return repository.findAll();
    }

    @Override
    public void deleteCard(Long id) {
        repository.deleteById(id);
    }
}
