<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  <!-- scriplet utilizado para poder colocar codigo java dentro do jsp -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link type="text/css"
              href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.js"></script>
        <script type="text/javascript" src="http://www.godtur.no/godtur/js/jquery-ui-1.8.18.custom.min.js"></script>

        <title>Add new ies</title>
    </head>
    <body>

        <form method="POST" action='ControllerIes' name="frmAddIes">  <!-- formulario que irar receber os dados de entrada e irar mandar pelo metodo post ao controlador(ControllerIes)onde por meio da dao e util irar mandar para o banco de dados-->
            
            <!--Ies ID :--> <input type="hidden" readonly="readonly" name="iesId"
                             value="<c:out value="${ies.iesId}" />" /> <br /> 
            Cod IES : <input
                type="text" name="cod_ies"
                value="<c:out value="${ies.cod_ies}" />" /> <br /> 
            Razao Social : <input
                type="text" name="razao_social"
                value="<c:out value="${ies.razao_social}" />" /> <br />
            CNPJ : <input
                type="text" name="cnpj"
                value="<c:out value="${ies.cnpj}" />" /> <br /> 

            Email : <input type="text" name="email" size="20"
                           value="<c:out value="${ies.email}" />" /> <br />

            Endereço : <input type="text" name="endereco"
                              value="<c:out value="${ies.endereco}" />" /> <br />

            Senha : <input type="text" name="senha"
                           value="<c:out value="${ies.senha}" />" /> <br />

            <input type="submit" value="Submit" />

            
        </form>
    </body>
</html>

