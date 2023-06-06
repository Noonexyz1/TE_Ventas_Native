<%
    String opcion = request.getParameter("opcion");
%>

<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("productos"))? "active":"" %>" href="productos.jsp">Productos</a>
    </li>

    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("clientes")) ? "active" : ""%>" href="clientes.jsp">Clientes</a>
    </li>

    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("ventas")) ? "active" : ""%>" href="ventas.jsp">Ventas</a>
    </li>

</ul>
