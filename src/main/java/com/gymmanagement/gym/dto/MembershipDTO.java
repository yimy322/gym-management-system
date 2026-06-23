package com.gymmanagement.gym.dto;

import java.math.BigDecimal;
import com.gymmanagement.gym.utils.SubscriptionStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MembershipDTO {

    private Long id;
    private String name;
    private Integer durationMonths;
    private BigDecimal price;
    private SubscriptionStatus status;

}
