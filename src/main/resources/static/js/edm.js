function addItem(item) {
	const itemHTML =
		'<div class="product card h-150 mt-3 mb-5" style="width: 18rem;">\n' +
		'    <div class="product-container">' +
		'    <img src="' + item.imagen + '" class="product-img  card-img-top" alt="image" style="height: 20rem; object-fit: cover;">\n' +
		'     </div> \n' +
		'    <div class="card-body d-flex flex-column justify-content-between" id="card-align">\n' +
		'    <div">\n' +
		'   <h5 class="card-title text-center">' + item.nombre + '</h5>\n' +
		'   <p class="card-text">' + item.descripcion + '</p>\n' +
		'    </div">\n' +
		'    <div">\n' +
		'   <p class="card-text">$' + item.precio + '</p>\n' +
		'   <a href="producto-detalle.html?id=' + item.id + '" class="btn btn-primary rounded-pill btn-lg w-100 mt-auto my-1" id="BtnAdd">Ver detalles</a>\n'+
		'   <a href="#" class="btn btn-primary rounded-pill btn-lg w-100 mt-auto " id="BtnAdd">Agregar al carrito</a>\n' +
		'    </div">\n' +
		'    </div>\n' +
		'</div>\n' +
		'<br/>';

	const itemsContainer = document.getElementById("list-items");
	itemsContainer.innerHTML += itemHTML;
}

const fetchProducts = () => {
	const requestOptions = {
		method: "GET",
		redirect: "follow"
	};

	fetch("http://localhost:8080/truefan/productos/", requestOptions)
		.then((response) => response.json())
		.then((data) => {
			data.forEach((product) => {
				if (product.genero === "EDM") {
					addItem(product);
					console.log(data)
				}
			});
		})
		.catch((error) => console.error("Error al obtener productos:", error));
};

window.onload = fetchProducts;