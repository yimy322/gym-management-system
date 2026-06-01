package com.gymmanagement.gym.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.gymmanagement.gym.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    @Override
    public BigDecimal getTotalAmount() {
        BigDecimal total = paymentRepository.sumAllAmounts();//validamos que haya registros
        return total != null ? total : BigDecimal.ZERO;
    }

}
