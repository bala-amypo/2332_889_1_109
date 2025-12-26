package com.example.demo.repository;

import com.example.demo.entity.CreditCardRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository
        extends JpaRepository<CreditCardRecord, Long> {
}
