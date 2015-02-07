<?php
$id = $_GET['id'];
$servername = "mysql4.000webhost.com";
$username = "a1780121_zeeshan";
$password = "premchopra123";
// Create connection
$conn = mysqli_connect($servername, $username, $password);

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// select database
$selected = mysqli_select_db($conn,"a1780121_ola") 
  or die("sorry, not able to connect");

$query = "SELECT * FROM drivername where driver_id=".$id;
$result = mysqli_query($conn,$query);
$row = mysqli_fetch_assoc($result);
$contents = $row['driver_name'];
echo $contents;
mysqli_close($conn);

?>