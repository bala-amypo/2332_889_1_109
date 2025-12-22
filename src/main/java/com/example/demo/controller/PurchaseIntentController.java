package com.example.demo.controller;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.service.PurchaseIntentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/intents")
@Tag(name = "Purchase Intents")
public class PurchaseIntentController {

    private final PurchaseIntentService intentService;

    public PurchaseIntentController(PurchaseIntentService intentService) {
        this.intentService = intentService;
    }

    @PostMapping
    public PurchaseIntentRecord createIntent(@RequestBody PurchaseIntentRecord intent) {
        return intentService.createIntent(intent);
    }

    @GetMapping("/user/{userId}")
    public List<PurchaseIntentRecord> getByUser(@PathVariable Long userId) {
        return intentService.getIntentsByUser(userId);
    }

    @GetMapping("/{id}")
    public PurchaseIntentRecord getById(@PathVariable Long id) {
        return intentService.getIntentById(id);
    }

    @GetMapping
    public List<PurchaseIntentRecord> getAll() {
        return intentService.getAllIntents();
    }
}
