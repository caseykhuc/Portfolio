<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Login</title>
    <link rel ="stylesheet" type="text/css" href ="style.css">
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
    <br><br><br>
    <form class="small-width" method="post" action="">
        <h2 class="center-text">User Login</h2>
        <p><label>Email: </label><input type ='text' id="email" name="email" > <br>
        <p><label>ID   : </label><input type ='text' id="id" name="id" > <br>
        <div class="small-button-linear">
            <input type ="submit" value="Login" name="submit"/>
            <input type="submit" name="back" value="Back"><br>
        </div>
    </form>

<?php
session_start();
if (isset($_POST["back"])) {
    header('location:index.html');
    exit();
}
if (isset($_POST["submit"])) {

    if (empty($_POST["email"]) || empty($_POST["id"]) )
        echo "Please fill all the fields..";
    elseif (!is_numeric($_POST["id"]))
        echo "ID must be numeric..";
    else {
        include('connect-db.php');
        //check user id
        $em = mysqli_real_escape_string($con,$_POST["email"]);
        $id = mysqli_real_escape_string($con,$_POST["id"]);
        $query = "select * from user where email = '$em' and user_id = $id ";
        $result = mysqli_query($con, $query)
            or die("Query failed ".mysqli_error($con));
        if (mysqli_num_rows($result) == 0 ) {
            echo "User login failed";
        }else{
            echo "Login success!";
            $_SESSION['username2'] = $id;
            header('location:user-portal.php');
            exit();
        }
        mysqli_close($con);
    }}

    ?>
</body>
</html>

