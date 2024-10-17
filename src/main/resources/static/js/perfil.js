const perfil = document.getElementById("titulosHeader");
const buttonPerf = document.getElementById("btnValidar");
const tel = document.getElementById("number")
const newtel = document.getElementById("number2")
const password = document.getElementById("password")
const newPass = document.getElementById("confirm-password")
const cerrarsesion = document.getElementById("cerrarsesion");
console.log("Hola mundo")

const myHeaders = new Headers();
	myHeaders.append("Authorization",`Bearer: ${localStorage.getItem("token")}` );
	myHeaders.append("Content-Type", "application/json");
	
window.addEventListener('load', function () {

    
	const requestOptions = {
	  method: "GET",
	  headers: myHeaders,
	  redirect: "follow"
	};

	fetch(`http://localhost:8080/truefan/usuarios/${localStorage.getItem("id")}`, requestOptions)
	  .then((response) => response.text())
	  .then((result) => {
		console.log(result)
		data =JSON.parse(result)
		perfil.innerHTML = `<p>Hola, ${data.firstName}</p>`
		
		})
	  .catch((error) => console.error(error));
    
    
})


buttonPerf.addEventListener("click", function(){
	
	if(tel.value!=="" && newtel.value!=="" && password.value!=="" && newPass.value!==""){
		const raw = JSON.stringify({
		  "phone": tel.value,
		  "nphone": newtel.value,
		  "password": password.value,
		  "npassword": newPass.value
		});
	
		const requestOptions = {
		  method: "PUT",
		  headers: myHeaders,
		  body: raw,
		  redirect: "follow"
	};
	   
	   const link = `http://localhost:8080/truefan/usuarios/${localStorage.getItem("id")}`;  	
	   fetch(link, requestOptions)
	  .then((response) => response.text())
	  .then((result) => {
		Swal.fire({
                    position: "center",
                    icon: "success",
                    title: "Se hicieron los cambios correspondientes",
                    showConfirmButton: true,
                    timer: 1500
                });
        
        tel.value = "";
        newtel.value = "";
        password.value = "";
        newPass.value = ""        
                
	  })
	  .catch((error) => console.error(error));
	  	
	}else if(tel.value!=="" && newtel.value!==""){
		const raw = JSON.stringify({
		  "phone": tel.value,
		  "nphone": newtel.value
		  
		});
	
		const requestOptions = {
		  method: "PUT",
		  headers: myHeaders,
		  body: raw,
		  redirect: "follow"
		};
		
		const link = `http://localhost:8080/truefan/usuarios/${localStorage.getItem("id")}`;
		console.log(link);  
		fetch(link, requestOptions)
	  .then((response) => response.text())
	  .then((result) => {
		Swal.fire({
                    position: "center",
                    icon: "success",
                    title: "Se hicieron los cambios correspondientes",
                    showConfirmButton: true,
                    timer: 1500
                });
                
          tel.value = "";
        newtel.value = "";
        password.value = "";
        newPass.value = ""
	  })
	  .catch((error) => console.error(error));
		
	}else if(password.value!=="" && newPass.value!==""){
		const raw = JSON.stringify({
		  "password": password.value,
		  "npassword": newPass.value
		});
	
		const requestOptions = {
		  method: "PUT",
		  headers: myHeaders,
		  body: raw,
		  redirect: "follow"
		};
		
		const link = `http://localhost:8080/truefan/usuarios/${localStorage.getItem("id")}`; 
		fetch(link, requestOptions)
		  .then((response) => response.text())
		  .then((result) => {
			console.log(result)
			
			Swal.fire({
                    position: "center",
                    icon: "success",
                    title: "Se hicieron los cambios correspondientes",
                    showConfirmButton: true,
                    timer: 1500
                });
			tel.value = "";
        newtel.value = "";
        password.value = "";
        newPass.value = ""
			
			})
		  .catch((error) => console.error(error)); 
		
	}else{
		
		Swal.fire({
                position: "center",
                icon: "error",
                title: "Tienes que llenar correctamente uno de los dos campos",
                showConfirmButton: false,
                timer: 4000
            });
	}
	
	
})


cerrarsesion.addEventListener("click", ()=>{
	
	localStorage.clear()
	Swal.fire({
                position: "center",
                icon: "success",
                title: `Te esperamos devuelta`,
                showConfirmButton: true,
                confirmButtonText: `
                  Ir al inicio
                ` 
            }).then((result) => {
                if (result.isConfirmed) {
					
                    window.location.href = "index.html"
                    
                }
            })
	
})