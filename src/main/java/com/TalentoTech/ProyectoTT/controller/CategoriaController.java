package com.TalentoTech.ProyectoTT.controller;

import com.TalentoTech.ProyectoTT.model.Categoria;
import com.TalentoTech.ProyectoTT.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.obtenerTodas();
    }

    @PostMapping
    public Categoria agregar(@RequestBody Categoria categoria) {
        return categoriaService.guardarCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
    }
}
