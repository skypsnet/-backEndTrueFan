function getProductIdFromURL() {
      const urlParams = new URLSearchParams(window.location.search);
      return urlParams.get('id'); // Obtiene el valor del parámetro 'id'
    }

    // Función que obtiene el producto por ID y muestra sus detalles
    function fetchProductDetails(productId) {
      const requestOptions = {
        method: "GET",
        redirect: "follow"
      };

      fetch(`http://localhost:8080/truefan/productos/${productId}`, requestOptions)  // Hace fetch a la API usando el ID del producto
        .then(response => response.json())
        .then(product => {
          // Inserta los detalles del producto en el HTML
          document.getElementById("product-name").textContent = `${product.nombre}`;
          document.getElementById("product-img").src = `${product.imagen}`;
          document.getElementById("product-price").textContent = "$"+`${product.precio}`;
          document.getElementById("product-description").textContent = `${product.descripcion}`;
        })
        .catch(error => console.error('Error al obtener detalles del producto:', error));
    }

    // Al cargar la página, obtener el ID de la URL y buscar el producto
    window.onload = () => {
      const productId = getProductIdFromURL(); // Obtiene el ID del producto desde la URL
      if (productId) {
        fetchProductDetails(productId); // Llama al fetch con el ID
      } else {
        console.error("No se encontró el ID del producto en la URL");
      }
    };