package com.example.tipcalculator.service;

import com.example.tipcalculator.model.TipRequest;
import com.example.tipcalculator.model.TipResponse;
import org.springframework.stereotype.Service;

@Service
public class TipCalculatorService {

    public TipResponse calculateTip(TipRequest request) {
        validateRequest(request);

        double billAmount = request.getBillAmount();
        int tipPercentage = request.getTipPercentage();

        double tipAmount = (billAmount * tipPercentage) / 100.0;
        double totalAmount = billAmount + tipAmount;

        // Округляем до 2 знаков после запятой
        tipAmount = Math.round(tipAmount * 100.0) / 100.0;
        totalAmount = Math.round(totalAmount * 100.0) / 100.0;

        return new TipResponse(billAmount, tipPercentage, tipAmount, totalAmount);
    }

    private void validateRequest(TipRequest request) {
        if (request.getBillAmount() == null || request.getBillAmount() <= 0) {
            throw new IllegalArgumentException("Сумма счёта должна быть больше нуля");
        }

        if (request.getTipPercentage() == null || request.getTipPercentage() < 0 || request.getTipPercentage() > 100) {
            throw new IllegalArgumentException("Процент чаевых должен быть от 0 до 100");
        }
    }
}