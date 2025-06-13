package com.shootdomy.apirest.apirest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shootdomy.apirest.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
