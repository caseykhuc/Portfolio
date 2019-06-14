<?php
/*session_start();

if (!$_SESSION['username']) {
    header('Location: log-in.php');
}
*/

// declaring some variables
$host = "localhost";
$user = "root";
$password = "";
$dbName = "id8173186_project2";

//Connect to the Server+Select DB
$con = mysqli_connect($host, $user, $password, $dbName)
or die("Connection is failed");
?>