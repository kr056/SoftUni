<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
</head>
<body>
<?php
for($j=1;$j<=9;$j++){

    for($i=0;$i<5;$i++){

        if($j==1 || $j==5 || $j==9){
            echo "<button style='background-color: blue';>1</button>";
        }
        elseif($j>1 && $j<5){
            if($i==0){
                echo "<button style='background-color: blue';>1</button>";
            }
            else{
                echo "<button>0</button>";
            }
        }
        else{
            if($i==4){
                echo "<button style='background-color: blue';>1</button>";
            }
            else{
                echo "<button>0</button>";
            }
        }
    }
    echo "<br/>";
}
?>
</body>
</html>