package com.TalentoTech.ProyectoTT.service;

import com.TalentoTech.ProyectoTT.model.Producto;
import com.TalentoTech.ProyectoTT.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Optional<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreIgnoreCase(nombre);
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public Producto actualizarProducto(Long id, Producto datosActualizados) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(datosActualizados.getNombre());
            producto.setDescripcion(datosActualizados.getDescripcion());
            producto.setPrecio(datosActualizados.getPrecio());
            producto.setCategoria(datosActualizados.getCategoria());
            producto.setImagenUrl(datosActualizados.getImagenUrl());
            producto.setStock(datosActualizados.getStock());
            return productoRepository.save(producto);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
}
