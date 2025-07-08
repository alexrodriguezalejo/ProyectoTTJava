package com.TalentoTech.ProyectoTT.repository;

import com.TalentoTech.ProyectoTT.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}