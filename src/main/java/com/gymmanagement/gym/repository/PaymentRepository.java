package com.gymmanagement.gym.repository;

import com.gymmanagement.gym.entities.Payment;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT SUM(p.amount) FROM Payment p")
    BigDecimal sumAllAmounts();

}
