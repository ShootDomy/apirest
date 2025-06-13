package com.shootdomy.apirest.apirest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shootdomy.apirest.apirest.Entities.Producto;
import com.shootdomy.apirest.apirest.Services.ProductoService;

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
  private ProductoService productoService;

  @GetMapping()
  public List<Producto> obtenerTodosProductos() {
    return productoService.obtenerProductos();
  }

  @GetMapping("/{id}")
  public Producto obtenerProductosPorId(@PathVariable Long id) {
    return productoService.obtenerProducto(id);
  }

  @PostMapping()
  public Producto crearProducto(@RequestBody Producto producto) {
    return productoService.crearProducto(producto);
  }

  @PutMapping("/{id}")
  public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
    Producto prod = productoService.obtenerProducto(id);

    prod.setNombre(producto.getNombre());
    prod.setPrecio(producto.getPrecio());

    return productoService.actualizarProducto(prod);
  }

  @DeleteMapping("/{id}")
  public String eliminarProducto(@PathVariable Long id) {
    productoService.eliminarProducto(id);

    return "Producto eliminado con exito";
  }

}
