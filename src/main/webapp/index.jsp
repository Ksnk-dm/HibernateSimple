<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<body>

    <form action="/indexServlet" method="get">
<input type="submit" value="Добавить в бд">
</form>
<form action="/DelServlet" method="get">
    <input type="submit" value="Очистить бд">
</form>

Курс за период 01.01.20 - 10.01.2020
    <p>Максимальный курс за период: ${max}</p>
    <p>Средний курс за период: ${avg}</p>

    Выберите валюту:
    <form action="/UpdateServlet" method="post" name="form1">
        <p><select name="list">
            <option value="USD">Доллар</option>
            <option value="EUR">Євро</option>
            <option value="RUB">Російський рубль</option>
            <option value="AUD">Австралійський долар</option>
            <option>CAD</option>
            <option>CNY</option>
            <option>HRK</option>
            <option>CZK</option>
            <option>DKK</option>
            <option>HKD</option>
            <option>HUF</option>
            <option>INR</option>
            <option></option>
        </select>
       <input type="submit" value="Отправить">

    </form>

</body>
</html>
