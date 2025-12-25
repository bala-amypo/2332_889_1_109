package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.service.CreditCardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRecordRepository creditCardRepository;

    public CreditCardServiceImpl(CreditCardRecordRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public List<CreditCardRecord> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    @Override
    public CreditCardRecord getCreditCardById(Long id) {
        return creditCardRepository.findById(id).orElse(null);
    }

    @Override
    public CreditCardRecord saveCreditCard(CreditCardRecord card) {
        return creditCardRepository.save(card);
    }

    @Override
    public void deleteCreditCard(Long id) {
        creditCardRepository.deleteById(id);
    }
}
