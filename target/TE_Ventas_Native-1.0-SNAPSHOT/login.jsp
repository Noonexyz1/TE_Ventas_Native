<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en"><head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v3.8.5">
        <title>Signin Template · Bootstrap</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sign-in/">

        

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


        <style>
          .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
          }

          @media (min-width: 768px) {
            .bd-placeholder-img-lg {
              font-size: 3.5rem;
            }
          }
          
          html, body {
              height: 100%;
          }
          body{
              display: flex;
              align-items: center;
              padding-top:  40px;
              padding-bottom: 40px;
              background-color: #f5f5f5;
          }
          .form-signin {
              width: 100%;
              max-width: 330px;
              padding: 15px;
              margin: auto;
          }
          .form-signin .checkbox{
              font-weight: 400;
          }
          .form-signin .form-floating:focus-within{
              z-index: 2;
          }
          .form-signin input[type="email"]{
              margin-bottom: -1px;
              border-bottom-right-radius: 0;
              border-bottom-left-radius: 0;
          }
          .form-signin input[type="password"]{
              margin-bottom: -1px;
              border-bottom-right-radius: 0;
              border-bottom-left-radius: 0;
          }
          
          
        </style>
       
    </head>
    <body class="text-center">
        <form class="form-signin" action="Login" method="POST">
            <img class="mb-4" src="https://lh3.googleusercontent.com/-cZ1RKSHgUmU/V-Xip9Ocm6I/AAAAAAAAMa0/MYRaXl0CdNk/s70-c/ingenieria-de-sistemas-2016-la-upea%25255B7%25255D.jpg?imgmax=800" alt="" width="72" height="72">
            <h1 class="h3 mb-3 font-weight-normal">Login</h1>
            
            <div class="form-floating">
                <label for="inputEmail" class="sr-only">Correo Electronico</label>
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
            </div>
            
            
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="">
            
            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me"> Me olvidé
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
            <p class="mt-5 mb-3 text-muted">© 2017-2019</p>
        </form>


    </body></html>