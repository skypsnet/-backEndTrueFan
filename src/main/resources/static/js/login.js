const email = document.getElementById("mail");
const password = document.getElementById("password");
const button = document.getElementById("btnValidar");
let isValidEmail = true


function validaPassEmail(element){

    return element.email == email.value && element.password == password.value;

}

function validarEmail(mail) {
    let pattern = /[^@ \t\r\n]+@[^@ \t\r\n]+\.[^@ \t\r\n]+/
    return pattern.test(mail)
}

const getUserData = async (id, token) => {
    
    const myHeaders = new Headers();
    myHeaders.append("Authorization", `Bearer: ${token}`);

    const requestOptions = {
    method: "GET",
    headers: myHeaders,
    redirect: "follow"
     };

    try{
       
      const getDataCall = await fetch(`http://localhost:8080/truefan/usuarios/${id}`, requestOptions); 
      const data = await getDataCall.json();
      console.log(data);
      return data;
    
    }catch(error){
        console.log(error)
    } 
    
}


button.addEventListener("click",(e)=>{

    e.preventDefault();

    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
    "email": email.value,
    "password": password.value
    });

    const requestOptions = {
    method: "POST",
    headers: myHeaders,
    body: raw,
    redirect: "follow"
    };

    fetch("http://localhost:8080/truefan/login/", requestOptions)
    .then((response) => response.text())
    .then(async (result) => {
        console.log(result);
        console.log("Hola Mundo");
        data = JSON.parse(result);


        dataUser = await getUserData(data.id, data.accessToken);
        console.log(data);
        console.log(data.error);

        if(data.error === undefined){
			
			localStorage.setItem("name",dataUser.firstName);
			localStorage.setItem("id",data.id)
			localStorage.setItem("token",data.accessToken)			
			
            Swal.fire({
                position: "center",
                icon: "success",
                title: `Bienvenido ${dataUser.firstName}`,
                showConfirmButton: true,
                confirmButtonText: `
                  Ir al inicio
                ` 
            }).then((result) => {
                if (result.isConfirmed) {
					
                    window.location.href = "index.html"
                    
                }
            });
        }else {
            Swal.fire({
                position: "center",
                icon: "error",
                title: "Usuario y/o contraseña incorrectos",
                showConfirmButton: false,
                timer: 4000
            });
        }
    
    })
    .catch((error) => console.error(error));
     
});