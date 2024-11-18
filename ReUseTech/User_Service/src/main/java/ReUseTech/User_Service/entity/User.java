package ReUseTech.User_Service.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
public class User {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

}