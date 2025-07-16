package com.TalentoTech.ProyectoTT.repository;

import com.TalentoTech.ProyectoTT.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Si más adelante agregás usuarios, podrías usar esto:
    // List<Pedido> findByUsuarioId(Long usuarioId);
}
