package com.example.demo.controller;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.service.CreditCardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@Tag(name = "Credit Cards")
public class CreditCardController {

    private final CreditCardService cardService;

    public CreditCardController(CreditCardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public CreditCardRecord addCard(@RequestBody CreditCardRecord card) {
        return cardService.addCard(card);
    }

    @PutMapping("/{id}")
    public CreditCardRecord updateCard(@PathVariable Long id,
                                       @RequestBody CreditCardRecord updated) {
        return cardService.updateCard(id, updated);
    }

    @GetMapping("/user/{userId}")
    public List<CreditCardRecord> getCardsByUser(@PathVariable Long userId) {
        return cardService.getCardsByUser(userId);
    }

    @GetMapping("/{id}")
    public CreditCardRecord getCard(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @GetMapping
    public List<CreditCardRecord> getAllCards() {
        return cardService.getAllCards();
    }
}
