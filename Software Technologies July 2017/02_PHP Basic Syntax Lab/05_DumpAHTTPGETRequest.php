<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<form>
    <div>Name:<input type="text" name="personName" /></div>
    <div>Age:<input type="number" name="age" /></div>
    <div>Town:</div>
    <select name="townId">
        <option value="10">Sofia</option>
        <option value="20">Varna</option>
        <option value="30">Plovdiv</option>
    </select>
    <div><input type="submit" /></div>
</form>
<?php
var_dump($_GET);
?>
</body>
</html>