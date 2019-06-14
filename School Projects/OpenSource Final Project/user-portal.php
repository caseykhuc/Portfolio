
<html>
<head>
    <meta charset="UTF-8">
    <title>User Portal</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>Hackathon Team Management</header>
<nav>
    <ul>
        <li><a href="register-user.php">User Registration</a></li>
        <li><a href="user-login.php">User Login</a></li>
        <li><a href="admin-login.php">Admin Login</a></li>
        <li><a href="upload.html">File Upload</a></li>
    </ul>
</nav>

<?php
session_start();
if (!$_SESSION['username2']) {
    header('Location: user-login.php');
}
if (isset($_POST['log-out'])) {
    logout();
}
function logout() {
    session_destroy();
    header('Location: user-login.php');
}
include('connect-db.php');

$id = $_SESSION['username2'];

$query = "select firstname, lastname from user where user_id = $id";
$result = mysqli_query($con, $query)
or die("Query failed ".mysqli_error($con));
$row = mysqli_fetch_row($result);
echo "<h2>Welcome " . $row[0] . " " . $row[1] . "!</h2>";

$query = "select group_id from user_group where user_id = $id";
$result = mysqli_query($con, $query)
or die("Query failed ".mysqli_error($con));

if (mysqli_num_rows($result) == 0)
    echo "You are not assigned to any group.";
else{
    $row = mysqli_fetch_row($result);
    $group_id = $row[0];
    echo "You are assigned to the group: ".$group_id."<br><br>";


    $query = "select firstname, lastname,address, email from user_group, user where group_id = $group_id and user_group.user_id = user.user_id";
    $result = mysqli_query($con, $query)
    or die("Query failed ".mysqli_error($con));
    echo "<table border='1' align='center' cellpadding='3'>";
    echo "<tr><th>First Name</th><th>Last Name</th><th>Address</th><th>Email</th></tr>";
    while (($row = mysqli_fetch_row($result)) == true ) {
        echo "<tr> <td>$row[0]</td> <td>$row[1]</td> <td>$row[2]</td> <td>$row[3]</td> </tr> ";
    }
}
mysqli_close($con);
?>
<form class="small-width" method="post" action="">
    <table></table> <!- Unless this line, table appears below Log Out button !!!!!!!
    <p></p><br>
    <div class="small-button-linear">
        <input type="submit" name="log-out" value="Log Out"><br>
    </div>
</form>

</body>
</html>

