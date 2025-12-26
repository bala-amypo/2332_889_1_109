package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.repository.CreditCardRepository;
import com.example.demo.service.CreditCardService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {
    
    private final CreditCardRepository creditCardRepository;
    
    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }
    
    @Override
    public CreditCardRecord addCard(CreditCardRecord creditCard) {
        return creditCardRepository.save(creditCard);
    }
    
    @Override
    public CreditCardRecord updateCard(Long id, CreditCardRecord creditCard) {
        creditCard.setId(id);
        return creditCardRepository.save(creditCard);
    }
    
    @Override
    public List<CreditCardRecord> getCardsByUser(Long userId) {
        return creditCardRepository.findByUserId(userId);
    }
    
    @Override
    public CreditCardRecord getCardById(Long id) {
        return creditCardRepository.findById(id).orElse(null);
    }
}