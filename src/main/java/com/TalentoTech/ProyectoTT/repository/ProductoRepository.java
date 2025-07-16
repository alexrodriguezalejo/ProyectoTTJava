package com.TalentoTech.ProyectoTT.repository;

import com.TalentoTech.ProyectoTT.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findByNombreIgnoreCase(String nombre);

    List<Producto> findByCategoriaId(Long categoriaId);
}
