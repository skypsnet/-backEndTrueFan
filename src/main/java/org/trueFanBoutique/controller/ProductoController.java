package org.trueFanBoutique.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.trueFanBoutique.model.Producto;
import org.trueFanBoutique.service.ProductoService;

@RestController
@RequestMapping(path="/truefan/productos/")

public class ProductoController {
	
	private final ProductoService productoService;
	
	@Autowired

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}//constructor
	
	@GetMapping
	public List<Producto> getProductos() {
		return productoService.getAllProductos();
	}//getProductos
	
	@GetMapping(path="{prodId}")
	public Producto getProducto(@PathVariable("prodId") Long prodId) {
		return productoService.getProducto(prodId);
	}//getProducto
	
	@PostMapping
	public Producto addProducto (@RequestBody Producto producto) {
		return productoService.addProducto(producto);
	}//addProducto
	
	@DeleteMapping(path="{prodId}")
	public Producto deleteProducto (@PathVariable("prodId") Long prodId) {
		return productoService.deleteProducto(prodId);
	}//deleteProducto
	
	@PutMapping(path="{prodId}")
	public Producto updateProducto (@PathVariable("prodId") Long prodId,
									@RequestParam(required=false) String nombre,
									@RequestParam(required=false) String descripcion,
									@RequestParam(required=false) String imagen,
									@RequestParam(required=false) Double precio,
									@RequestParam(required=false) String genero){
		
		return productoService.updateProducto(prodId, nombre, descripcion, imagen, precio,genero);
	}//deleteProducto
	
}//productoController
