package com.TalentoTech.ProyectoTT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/productos")
    public String vistaProductos() {
        return "productos";
    }

    @GetMapping("/categorias")
    public String vistaCategorias() {
        return "categorias";
    }

    @GetMapping("/carrito")
    public String vistaCarrito() {
        return "carrito";
    }

    @GetMapping("/pedidos")
    public String vistaPedidos() {
        return "pedidos";
    }

    @GetMapping("/historial")
    public String vistaHistorial() {
        return "historial";
    }
}
