<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
<form>
    N: <input type="text" name="num" />
    <input type="submit" />
</form>
<?php
if(isset($_GET['num'])){
    $num=intval($_GET['num']);
    $sum=1;
    for($i=$num;$i>=1;$i--){
       $sum*=$i;
    }
    echo $sum;
}
?>
</body>
</html>