<html>
<head>
<title>Add New Record in MySQL Database</title>
</head>
<body>
<?php
if(isset($_POST['add']))
{
$servername = "mysql4.000webhost.com";
$username = "a1780121_zeeshan";
$password = "premchopra123";
// Create connection
$conn = mysqli_connect($servername, $username, $password);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$id=$_POST['event_id'];
$name=$_POST['event_name'];
$lat=$_POST['event_lat'];
$long=$_POST['event_long'];
$add=$_POST['event_add'];
$time=$_POST['event_time'];
/*
$query = "INSERT INTO employee ".
       "(emp_name,emp_address, emp_salary, join_date) ".
       "VALUES('$emp_name','$emp_address',$emp_salary, NOW())";*/
 $query = "INSERT INTO  `a1780121_ola`.`eventdata`". 
 "(event_id ,event_name ,event_lattitude ,event_longitude ,event_address ,event_end_time ,number_drivers)".
"VALUES ('$id',  '$name',  '$lat',  '$long',  '$add',  '$time',  '0'
)";
$selected = mysqli_select_db($conn,"a1780121_ola") 
  or die("sorry, not able to connect");

$result = mysqli_query($conn,$query);
if(! $result )
{
  die('Could not enter data: ' . mysql_error());
}
echo "Entered data successfully\n";
mysqli_close($conn);
}
else
{
?>
<form method="post" action="<?php $_PHP_SELF ?>">
<table width="400" border="0" cellspacing="1" cellpadding="2">
<tr>
<td width="100">Event id</td>
<td><input name="event_id" type="text" id="event_id"></td>
</tr>
<tr>
<td width="100">Event Name</td>
<td><input name="event_name" type="text" id="event_name"></td>
</tr>
<tr>
<td width="100">Event latitude</td>
<td><input name="event_lat" type="text" id="event_lat"></td>
</tr>
<tr>
<td width="100">Event longitude</td>
<td><input name="event_long" type="text" id="event_long"></td>
</tr>
<tr>
<td width="100">Event Address</td>
<td><input name="event_add" type="text" id="event_add"></td>
</tr>
<tr>
<td width="100">Event End Time</td>
<td><input name="event_time" type="text" id="event_time" placeholder="YYYY-MM-DD HH:MM:SS"></td>
</tr>
<tr>
<td width="100"> </td>
<td> </td>
</tr>
<tr>
<td width="100"> </td>
<td>
<input name="add" type="submit" id="add" value="Add Entries">
</td>
</tr>
</table>
</form>
<?php
}
?>
</body>
</html>