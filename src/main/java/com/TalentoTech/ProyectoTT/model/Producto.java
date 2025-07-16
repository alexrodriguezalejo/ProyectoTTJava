package com.TalentoTech.ProyectoTT.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private double precio;

    private String imagenUrl;

    private int stock;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
