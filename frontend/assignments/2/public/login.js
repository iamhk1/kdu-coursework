async function handleLogin() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    console.log(username,password);
    const data = {
        username: username,
        password: password
    };
    const response = await fetch("http://localhost:3000/api/user/login", {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
    });
    const res=await response.json();

    if (res.status==true) {
        
        window.location.href = `http://localhost:3000/index.html?name=${username}`; 
    } else {
        alert("Invalid username or password. Please try again.");
    }
}


document.getElementById("login").addEventListener("click", handleLogin);