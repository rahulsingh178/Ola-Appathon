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

$query1 = "SELECT number_drivers FROM eventdata WHERE event_id=".$id;
$result1 = mysqli_query($conn,$query1);

$row = $result1->fetch_assoc();
$value = (int) $row['number_drivers'];
$value = $value+1;
echo $value;

$query2 = "UPDATE eventdata SET number_drivers = $value WHERE event_id=".$id;
$result2 = mysqli_query($conn,$query2);

echo "Done!";

mysqli_close($conn);
?>
