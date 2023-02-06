<%-- 
    Document   : viewnote
    Created on : 5-Feb-2023, 5:27:17 PM
    Author     : darkn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p> <strong> Title: </strong> ${note.title}</p>
        <p> <strong> Contents: </strong> </p>
        <p> ${note.contents} </p>
        <a href="note?page=edit">Edit</a>
    </body>
</html>
