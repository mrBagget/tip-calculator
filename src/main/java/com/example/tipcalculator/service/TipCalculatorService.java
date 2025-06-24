package com.example.tipcalculator.service;

import com.example.tipcalculator.model.TipRequest;
import com.example.tipcalculator.model.TipResponse;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class TipCalculatorService {

    // Курсы валют (можно заменить на API)
    private final Map<String, Double> currencyRates = new HashMap<>();

    public TipCalculatorService() {
        currencyRates.put("RUB", 1.0);
        currencyRates.put("USD", 0.011);
        currencyRates.put("EUR", 0.010);
        currencyRates.put("CNY", 0.078);
    }

    public TipResponse calculateTip(TipRequest request) {
        validateRequest(request);

        double billAmount = request.getBillAmount();
        int tipPercentage = request.getTipPercentage();
        int numberOfPeople = request.getNumberOfPeople() != null ? request.getNumberOfPeople() : 1;
        boolean roundUp = request.getRoundUp() != null ? request.getRoundUp() : false;
        String currency = request.getCurrency() != null ? request.getCurrency() : "RUB";

        // Основные расчеты
        double tipAmount = (billAmount * tipPercentage) / 100.0;
        double totalAmount = billAmount + tipAmount;

        // Расчеты на человека
        double amountPerPerson = totalAmount / numberOfPeople;
        double tipPerPerson = tipAmount / numberOfPeople;

        boolean wasRoundedUp = false;

        // Округление если нужно
        if (roundUp) {
            amountPerPerson = Math.ceil(amountPerPerson);
            totalAmount = amountPerPerson * numberOfPeople;
            tipAmount = totalAmount - billAmount;
            tipPerPerson = tipAmount / numberOfPeople;
            wasRoundedUp = true;
        } else {
            // Обычное округление до 2 знаков
            tipAmount = Math.round(tipAmount * 100.0) / 100.0;
            totalAmount = Math.round(totalAmount * 100.0) / 100.0;
            amountPerPerson = Math.round(amountPerPerson * 100.0) / 100.0;
            tipPerPerson = Math.round(tipPerPerson * 100.0) / 100.0;
        }

        return new TipResponse(
                billAmount,
                tipPercentage,
                tipAmount,
                totalAmount,
                numberOfPeople,
                amountPerPerson,
                tipPerPerson,
                currency,
                wasRoundedUp
        );
    }

    // Конвертация валют
    public TipResponse convertCurrency(TipResponse response, String targetCurrency) {
        if (!currencyRates.containsKey(targetCurrency)) {
            throw new IllegalArgumentException("Неподдерживаемая валюта: " + targetCurrency);
        }

        double rate = currencyRates.get(targetCurrency) / currencyRates.get(response.getCurrency());

        response.setBillAmount(Math.round(response.getBillAmount() * rate * 100.0) / 100.0);
        response.setTipAmount(Math.round(response.getTipAmount() * rate * 100.0) / 100.0);
        response.setTotalAmount(Math.round(response.getTotalAmount() * rate * 100.0) / 100.0);
        response.setAmountPerPerson(Math.round(response.getAmountPerPerson() * rate * 100.0) / 100.0);
        response.setTipPerPerson(Math.round(response.getTipPerPerson() * rate * 100.0) / 100.0);
        response.setCurrency(targetCurrency);

        return response;
    }

    // Рекомендация процента чаевых по типу заведения
    public int recommendTipPercentage(String serviceType) {
        return switch (serviceType.toLowerCase()) {
            case "restaurant", "ресторан" -> 15;
            case "bar", "бар" -> 18;
            case "cafe", "кафе" -> 10;
            case "delivery", "доставка" -> 10;
            case "taxi", "такси" -> 15;
            case "hotel", "отель" -> 20;
            default -> 15;
        };
    }

    private void validateRequest(TipRequest request) {
        if (request.getBillAmount() == null || request.getBillAmount() <= 0) {
            throw new IllegalArgumentException("Сумма счёта должна быть больше нуля");
        }

        if (request.getTipPercentage() == null || request.getTipPercentage() < 0 || request.getTipPercentage() > 100) {
            throw new IllegalArgumentException("Процент чаевых должен быть от 0 до 100");
        }

        if (request.getNumberOfPeople() != null && request.getNumberOfPeople() <= 0) {
            throw new IllegalArgumentException("Количество людей должно быть больше нуля");
        }
    }
}