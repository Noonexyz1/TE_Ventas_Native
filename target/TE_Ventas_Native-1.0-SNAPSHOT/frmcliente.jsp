<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Punto de venta</title>
    </head>
    <body>

        <div class="container">

            <h1>Formulario de clientes</h1>

            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="clientes"/>
            </jsp:include>

            <br>
            <form action="ClienteControlador" method="POST">
                <input type="hidden" name="id" value="${cliente.id}">
                <div class="mb-3">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${cliente.nombre}" placeholder="Escriba su nombre">
                    
                </div>
                
                <div class="mb-3">
                    <label for="" class="form-label">Correo Electronico</label>
                    <input type="email" class="form-control" name="correo" value="${cliente.correo}" placeholder="Escriba su correo">

                </div>
                
                <div class="mb-3">
                    <label for="" class="form-label">Celular</label>
                    <input type="text" class="form-control" name="celular" value="${cliente.celular}" placeholder="Escriba su celular">

                </div>
                
                
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>


        </div>









        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
