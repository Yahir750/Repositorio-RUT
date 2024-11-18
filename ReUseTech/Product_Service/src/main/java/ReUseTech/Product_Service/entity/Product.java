package ReUseTech.Product_Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products") // Asegúrate de que la tabla tenga este nombre en la base de datos
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID del producto, es la clave primaria

    private String name; // Nombre del producto
    private double price; // Precio del producto
    private String description; // Descripción del producto
}