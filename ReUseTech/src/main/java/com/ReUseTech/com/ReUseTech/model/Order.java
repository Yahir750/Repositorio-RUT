
package com.ReUseTech.com.ReUseTech.model;


import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String status; // Por ejemplo: "PENDIENTE", "COMPLETADA", "CANCELADA"

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> items;

    public Object getUser() {
        return null;
    }

    // Otros campos que consideres necesarios
}
