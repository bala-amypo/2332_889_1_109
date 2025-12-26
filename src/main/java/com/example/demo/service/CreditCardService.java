package com.example.demo.service;

import com.example.demo.entity.CreditCardRecord;
import java.util.List;

public interface CreditCardService {
    CreditCardRecord addCard(CreditCardRecord creditCard);
    CreditCardRecord updateCard(Long id, CreditCardRecord creditCard);
    List<CreditCardRecord> getCardsByUser(Long userId);
    CreditCardRecord getCardById(Long id);
}