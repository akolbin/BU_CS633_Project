import React from 'react';

function Login() {

  return (
    <html lang="en">
      <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
    
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous" />
    
        <title>BU Hotel Login</title>
        <link href="login.css" rel="stylesheet" /> 
      </head>
      <body class="text-center">
        <main class="form-signin">
          <form action="http://localhost:3000/">
            <img class="mb-4" src="./logo.png" alt="" height="300" />
            <h1 class="h3 mb-3 fw-normal"><b>BU Hotel</b> - Login</h1>
        
            <div class="form-floating">
              <input type="string" class="form-control" id="username" placeholder="username" />
              <label for="floatingInput">Username</label>
            </div>
            <div class="form-floating">
              <input type="password" class="form-control" id="password" placeholder="Password" />
              <label for="floatingPassword">Password</label>
            </div>
        
            <button type="submit" class="w-100 btn btn-lg btn-primary mt-3">
                Login
            </button>
          </form>
        </main>
      </body>
    </html>
  );
}

export default Login;