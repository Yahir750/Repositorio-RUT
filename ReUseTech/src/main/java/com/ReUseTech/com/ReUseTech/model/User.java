package com.ReUseTech.com.ReUseTech.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Setter
@Getter
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
}
