package com.shootdomy.apirest.apirest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shootdomy.apirest.apirest.Entities.Producto;
import com.shootdomy.apirest.apirest.Repository.ProductoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/productos")
public class ProductoController {
  @Autowired
  private ProductoRepository productoRepository;

  @GetMapping()
  public List<Producto> obtenerTodosProductos() {
    return productoRepository.findAll();
  }

  @GetMapping("/{id}")
  public Producto obtenerProductosPorId(@PathVariable Long id) {
    return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con id " + id));
  }

  @PostMapping()
  public Producto crearProducto(@RequestBody Producto producto) {
    return productoRepository.save(producto);
  }

  @PutMapping("/{id}")
  public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
    Producto prod = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con id " + id));

    prod.setNombre(producto.getNombre());
    prod.setPrecio(producto.getPrecio());

    return productoRepository.save(prod);
  }

  @DeleteMapping("/{id}")
  public String eliminarProducto(@PathVariable Long id) {
    Producto producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con id " + id));

    productoRepository.delete(producto);

    return "Producto eliminado con exito";
  }

}
