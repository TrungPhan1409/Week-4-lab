<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <form method="post" action ="note?page=view">
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <Strong> Title </strong>
        <input type="text" name="title" value="${note.title}"><br>
        <strong> Contents: </strong> 
        <textarea name="contents" cols="50" rows="5"> ${note.contents} </textarea><br
    </form>
    <input type ="submit" value="save">
    </body>