package com.example.demo.service;

import com.example.demo.entity.CreditCardRecord;
import java.util.List;

public interface CreditCardService {

    List<CreditCardRecord> getAllCards();

    CreditCardRecord getCreditCardById(Long id);

    CreditCardRecord saveCreditCard(CreditCardRecord card);

    void deleteCreditCard(Long id);
}
