package com.gymmanagement.gym.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {

    private Long id;
    private String dni;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

}
