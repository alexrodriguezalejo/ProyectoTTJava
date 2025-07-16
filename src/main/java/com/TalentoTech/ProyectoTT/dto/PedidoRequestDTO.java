package com.TalentoTech.ProyectoTT.dto;

import lombok.Data;

import java.util.List;

@Data
public class PedidoRequestDTO {
    private List<ItemPedidoRequestDTO> items;
}
