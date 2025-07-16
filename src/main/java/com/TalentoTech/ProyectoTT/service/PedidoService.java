package com.TalentoTech.ProyectoTT.service;

import com.TalentoTech.ProyectoTT.model.ItemPedido;
import com.TalentoTech.ProyectoTT.model.Pedido;
import com.TalentoTech.ProyectoTT.model.Producto;
import com.TalentoTech.ProyectoTT.repository.ItemPedidoRepository;
import com.TalentoTech.ProyectoTT.repository.PedidoRepository;
import com.TalentoTech.ProyectoTT.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public Pedido crearPedido(List<ItemPedido> items) {
        List<ItemPedido> itemsValidados = new ArrayList<>();
        double total = 0;

        for (ItemPedido item : items) {
            Producto producto = productoRepository.findById(item.getProducto().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            if (producto.getStock() < item.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - item.getCantidad());
            productoRepository.save(producto);

            item.setProducto(producto);
            item.setSubtotal(producto.getPrecio() * item.getCantidad());
            itemsValidados.add(itemPedidoRepository.save(item));

            total += item.getSubtotal();
        }

        Pedido pedido = Pedido.builder()
                .fecha(LocalDateTime.now())
                .estado("pendiente")
                .total(total)
                .items(itemsValidados)
                .build();

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido obtenerPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }
}
