<!DOCTYPE html>
<html>
  
<body>
    <center>
        <h1 style="color: green;">
            Prakash Thapaliya
        </h1>
  
        <h3>
            Program to print multiplication<br>
            table of any number in PHP
        </h3>
  
        <form method="POST">
            Enter a number: 
            <input type="text" name="number">
              
            <input type="Submit" 
                value="Get Multiplication Table">
        </form>
    </center>
</body>
  
</html>
  
<?php
if($_POST) {
    $num = $_POST["number"];
  
    echo nl2br("<p style='text-align: center;'>
        Multiplication Table of $num: </p>
    ");
          
    for ($i = 1; $i <= 10; $i++) {
        echo ("<p style='text-align: center;'>$num"
            . " X " . "$i" . " = " 
            . $num * $i . "</p>
        ");
    }
}
?>