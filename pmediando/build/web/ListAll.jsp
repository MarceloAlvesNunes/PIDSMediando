<%-- 
    Document   : ListAll
    Created on : 27/11/2019, 10:49:23
    Author     : Marcelo
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"  %>  <!-- scriplet utilizado para poder colocar codigo java dentro do jsp-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Show All Ies</title>
    </head>
    <body>
        <table border=1> <!-- tabela que irar receber os dados e mostrar na tela -->
            <thead>
                <tr bgcolor="#eaeaea">
                    <!--<th> Ies_Id </th> -->
                    <th> Cad_Ies </th> 
                    <th> Razão_Social </th> 
                    <th> Cnpj </th> 
                    <th> Endereço </th>
                    <th> Email </th> 
                    <th> Senha </th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${Ies}" var="ies"> <!-- for que irar criar novos campos para guardar novos dados -->
                    <tr>
                        <!out = ao println!/>
                <!--<td></td>-->
                <td><c:out value="${ies.cod_ies}" /></td>
                <td><c:out value="${ies.razao_social}" /></td>
                <td><c:out value="${ies.cnpj}" /></td>
                <td><c:out value="${ies.endereco}" /></td>
                <td><c:out value="${ies.email}" /></td>
                <td><c:out value="${ies.senha}" /></td>

                <td><a href="ControllerIes?action=edit&iesId=<c:out value="${ies.iesId}"/>">Update</a></td>
                <td><a href="ControllerIes?action=delete&iesId=<c:out value="${ies.iesId}"/>">Delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table> 
</br>
<form method="POST" action='ies.jsp' name="frmAddIes">
    <input type="submit" value="Adicionar Ies"/>
</form>
</body>
</html>