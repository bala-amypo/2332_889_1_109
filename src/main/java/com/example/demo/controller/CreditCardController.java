package com.example.demo.controller;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.service.CreditCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping
    public CreditCardRecord addCard(@RequestBody CreditCardRecord card) {
        return creditCardService.addCard(card);
    }

    @GetMapping("/{id}")
    public CreditCardRecord getCard(@PathVariable Long id) {
        return creditCardService.getCardById(id);
    }

    @GetMapping
    public List<CreditCardRecord> getAllCards() {
        return creditCardService.getAllCards();
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        creditCardService.deleteCard(id);
    }
}
