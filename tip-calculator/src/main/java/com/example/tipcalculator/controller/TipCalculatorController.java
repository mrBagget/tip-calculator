package com.example.tipcalculator.controller;

import com.example.tipcalculator.model.TipRequest;
import com.example.tipcalculator.model.TipResponse;
import com.example.tipcalculator.service.TipCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TipCalculatorController {

    @Autowired
    private TipCalculatorService tipCalculatorService;

    // Главная страница
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tipRequest", new TipRequest());
        return "index";
    }

    // REST API endpoint для расчёта чаевых
    @PostMapping("/api/calculate")
    @ResponseBody
    public ResponseEntity<?> calculateTipApi(@RequestBody TipRequest request) {
        try {
            TipResponse response = tipCalculatorService.calculateTip(request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Внутренняя ошибка сервера");
        }
    }

    // Обработка формы (для веб-интерфейса)
    @PostMapping("/calculate")
    public String calculateTip(@ModelAttribute TipRequest request, Model model) {
        try {
            TipResponse response = tipCalculatorService.calculateTip(request);
            model.addAttribute("result", response);
            model.addAttribute("tipRequest", request);
            return "index";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("tipRequest", request);
            return "index";
        }
    }
}