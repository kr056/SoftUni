<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<?php
$msgAfterCel="";
if(isset($_GET['cel'])) {
    $cel = floatval($_GET['cel']);
    $fah = celsiusToFahrenheit($cel);
    $msgAfterCel = "$cel &deg;C = $fah &deg;F";
}
$msgAfterFah="";
if(isset($_GET['fah'])) {
    $fah = floatval($_GET['fah']);
    $cel = fahrenheitToCelsius($fah);
    $msgAfterFah = "$fah &deg;F = $cel &deg;C";
}
function celsiusToFahrenheit(float $celsius) : float
{
    return $celsius*1.8 +32;
}
function fahrenheitToCelsius(float $fahrenheit) : float
{
    return ($fahrenheit-32)/1.8;
}
?>
<form>
    Celsius:
    <input type="number" name="cel"  />
    <input type="submit" value="Convert" />
    <?= $msgAfterCel ?>
</form>

<form>
    Fahrenheit:
    <input type="number" name="fah" />
    <input type="submit" value="Convert" />
    <?= $msgAfterFah ?>

</form>
</body>
</html>