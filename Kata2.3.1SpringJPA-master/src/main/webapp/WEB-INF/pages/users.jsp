<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: iness
  Date: 05.11.2022
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>

<div>
    <form action="add" method="get">
        <input type="text" name="name" placeholder="Имя">
        <input type="text" name="lastName" placeholder="Фамилия">
        <input type="text" name="email" placeholder="Email">
        <input type="submit" value="add"></form>
    </form>
</div>

<div>
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">FirstName</th>
            <th scope="col">LastName</th>
            <th scope="col">Email</th>
            <th scope="col">Update</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="user, Stat : ${userList}">
            <form action="update" method="get">
                <td th:text="${user.getId()}">
                <td><input type="text" name="name" placeholder="Имя" th:value="${user.getFirstName()}"></td>
                <td><input type="text" name="lastName" placeholder="Фамилия" th:value="${user.getLastName()}"></td>
                <td><input type="text" name="email" placeholder="Email" th:value="${user.getEmail()}"></td>
                <td><input type="number" name="id" placeholder="ID изменяемого пользователя" th:value="${user.getId()}">
                    <input type="submit" value="update"></td>
            </form>
            <td><form action="delete" method="get">
                <input type="number" name="id" placeholder="ID пользователя" th:value="${user.getId()}">
                <input type="submit" value="delete"></form></td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>