<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<form>
     Name:<input type="text" name="person"/>
    <input type="submit"/>
</form>
<?php
if(isset($_GET['person'])){
    $name=htmlspecialchars($_GET['person']);
    echo  "Hello,$name!";
}else{?>
    <form>
    Name:<input type="text" name="person"/>
    <input type="submit"/>
</form><?php
}
?>
</body>
</html>