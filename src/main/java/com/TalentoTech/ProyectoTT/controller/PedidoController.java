package com.TalentoTech.ProyectoTT.controller;

import com.TalentoTech.ProyectoTT.dto.ItemPedidoRequestDTO;
import com.TalentoTech.ProyectoTT.dto.PedidoRequestDTO;
import com.TalentoTech.ProyectoTT.model.ItemPedido;
import com.TalentoTech.ProyectoTT.model.Pedido;
import com.TalentoTech.ProyectoTT.model.Producto;
import com.TalentoTech.ProyectoTT.repository.ProductoRepository;
import com.TalentoTech.ProyectoTT.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody PedidoRequestDTO pedidoDTO) {
        try {
            List<ItemPedido> items = new ArrayList<>();

            for (ItemPedidoRequestDTO itemDTO : pedidoDTO.getItems()) {
                Producto producto = productoRepository.findById(itemDTO.getProductoId())
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado (ID: " + itemDTO.getProductoId() + ")"));

                ItemPedido item = ItemPedido.builder()
                        .producto(producto)
                        .cantidad(itemDTO.getCantidad())
                        .build();

                items.add(item);
            }

            Pedido pedido = pedidoService.crearPedido(items);
            return ResponseEntity.ok(pedido);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPorId(@PathVariable Long id) {
        try {
            Pedido pedido = pedidoService.obtenerPorId(id);
            return ResponseEntity.ok(pedido);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
