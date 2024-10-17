package org.trueFanBoutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trueFanBoutique.model.Producto;
import org.trueFanBoutique.repository.ProductoRepository;

@Service
public class ProductoService {
	
	private final ProductoRepository productoRepository;

	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	public List<Producto> getAllProductos() {

		return productoRepository.findAll();
	}

	public Producto getProducto(Long prodId) {
		return productoRepository.findById(prodId)
				.orElseThrow(() -> new IllegalArgumentException("El producto con el id [" + prodId + "] no existe."));
	}

	public Producto addProducto(Producto producto) {
		Optional<Producto> prod = productoRepository.findByNombre(producto.getNombre());
		if(prod.isEmpty()) {
			return productoRepository.save(producto);
		}else {
			System.out.println("el producto ["+producto.getNombre()
					+ "] ya se encuentra registrado");
			return null;
		}
	}//addProducto

	public Producto deleteProducto(Long prodId) {
		Producto prod = null;
			if (productoRepository.existsById(prodId)) {
				prod = productoRepository.findById(prodId).get();
				productoRepository.deleteById(prodId);
			}
		return prod;
	}//deleteProducto

	public Producto updateProducto(Long prodId, String nombre, String descripcion, String imagen,
			Double precio,String genero) {
		Producto prod = null;
				if (productoRepository.existsById(prodId)) {
				Producto producto = productoRepository.findById(prodId).get();
				if (nombre != null)
					producto.setNombre(nombre);
				if (descripcion != null)
					producto.setDescripcion(descripcion);
				if (imagen != null)
					producto.setImagen(imagen);
				if (precio != null)
					producto.setPrecio(precio);
				if (genero != null)
					producto.setGenero(genero);
				prod = producto;
				productoRepository.save(producto);
				}
		return prod;
	}

}
