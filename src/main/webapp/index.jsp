<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<body>
Удалить валюту с бд по названию (usd,rub и т.д.)
<form action="/DelServlet" method="get" name="form1">
    <input type="text" name="delname">
    <input type="submit" value="удалить валюту">
</form>


Введите почту для добавления рассылки:
<form method="get" action="/AddEmailServlet">
    Почта: <input type="text" name="email">
    <p>Какая валюта (USD,EUR, RUB и т.д.) <input type="text" name="cur">
    <p><input type="submit" value="Добавить почту"/></p>
</form>
<form method="get" action="/delemail">
    <p>Введите почту для удаления <input type="text" name="delemail">
    <p><input type="submit" value="удалить почту"/></p>
</form>

</body>
</html>
