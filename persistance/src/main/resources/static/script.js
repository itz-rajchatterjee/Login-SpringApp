function sendData(url) {
    const usercode = document.getElementById("usercode").value;
    const password = document.getElementById("password").value;
  
    fetch("http://localhost:8130/api"+url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ usercode, password })
    })
    .then(response => {
      if (response.ok) {
        return response.text();
      }
      throw new Error("Request failed.");
    })
    .then(data => {
      alert(`Success: ${data}`);
    })
    .catch(error => {
      alert(`Error: ${error}`);
    });
  }
  
  document.getElementById("loginBtn").addEventListener("click", function () {
    sendData("/login");
  });
  
  document.getElementById("createBtn").addEventListener("click", function () {
    sendData("/create-user");
  });
  