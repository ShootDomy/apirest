package com.shootdomy.apirest.apirest.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import lombok.AllArgsConstructor;

import com.shootdomy.apirest.apirest.Entities.Producto;
import com.shootdomy.apirest.apirest.Repository.ProductoRepository;

@Service
// @AllArgsConstructor
public class ProductoService {
  @Autowired
  private ProductoRepository productoRepository;

  public Producto crearProducto(Producto producto) {
    return productoRepository.save(producto);
  }

  public Producto actualizarProducto(Producto producto) {
    return productoRepository.save(producto);
  }

  public Producto obtenerProducto(Long id) {
    return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con id " + id));
  }

  public Producto eliminarProducto(Long id) {
    Producto producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con id " + id));

    productoRepository.delete(producto);

    return producto;
  }

  public List<Producto> obtenerProductos() {
    return productoRepository.findAll();
  }
}
