<%-- 
    Document   : album-form
    Created on : 19 mar 2026, 15:18:35
    Author     : katia
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Mis Álbums</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>

    <body>
        <%@include file="/WEB-INF/jsp/fragments/header.jspf" %>
        <header class="about-header">
            <img src="${pageContext.request.contextPath}/assets/img/header2.jpg" />
            <h1>Mis Álbums</h1>
        </header>

        <main class="about-main">
            <c:if test="${album == null}">
                Nuevo álbum
            </c:if>

            <c:if test="${album != null}">
                Editar álbum
            </c:if>

            <c:if test="${error != null}">
                <p style="color: red">${error}</p>
            </c:if>

            <form action="albums" method="post" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${album.id}">

                <label>Título</label>
                <br><!-- comment -->
                <input type="text" name="titulo" value="${album.titulo}" required>
                <br><br>

                <label>Descripción</label>
                <br><!-- comment -->
                <textarea name="descripcion" required>${album.descripcion}</textarea>
                <br><br>

                <label>Portada</label>
                <br><!-- comment -->
                <input type="file" name="imagen" accept="image/png" required>
                <br><br>
                
                <button type="submit">Guardar</button>
            </form>
                
                <a href="albums">Volver</a>
                
        </main>
        <%@include file="/WEB-INF/jsp/fragments/footer.jspf" %>
    </body>
</html>
