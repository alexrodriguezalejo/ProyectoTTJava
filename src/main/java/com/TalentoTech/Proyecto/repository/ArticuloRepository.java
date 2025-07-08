package com.TalentoTech.Proyecto.repository;

import com.TalentoTech.Proyecto.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}