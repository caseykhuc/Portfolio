<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register User</title>
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
    <form class="small-width" method ="post" >
        <h2 class="center-text">User Register</h2>
        <p><label>First Name: </label><input type ='text' id="fname" name="fname" > <br>
        <p><label>Last Name : </label><input type ='text' id="lname" name="lname" > <br>
        <p><label>Email     : </label><input type ='text' id="email" name="email" > <br>
        <p><label>Address   : </label><input type ='text' id="addr" name="addr" > <br>
        <div class="small-button-linear">
            <input type ="submit" value="Register" name="submit"/>
            <input type="submit" name="back" value="Back"><br>
        </div>
    </form>

<?php
if (isset($_POST["back"])) {
    header('location:index.html');
    exit();
}
if (isset($_POST["submit"])) {

    if (empty($_POST["fname"]) || empty($_POST["lname"]) || empty($_POST["email"]) || empty($_POST["addr"]) )
        echo "Please fill all the fields..";
    elseif (!strpos($_POST["email"], '@'))
        echo "Please enter a valid email address";
    else {
        include('connect-db.php');

        //check if this email is already registered
        $em = mysqli_real_escape_string($con,$_POST["email"]);
        $query = "select * from user where email = '$em'";
        $result = mysqli_query($con, $query);
        if (mysqli_num_rows($result) != 0 )
            echo "This email is already registered...";
        else {

            //create user id
            while (true) {
                $id = rand(1, 999999);
                $query = "select * from user where user_id = $id";
                $result = mysqli_query($con, $query);
                if (mysqli_num_rows($result) == 0)
                    break;
            }

            //create record
            $fn = mysqli_real_escape_string($con, $_POST["fname"]);
            $ln = mysqli_real_escape_string($con, $_POST["lname"]);
            $ad = mysqli_real_escape_string($con, $_POST["addr"]);

            $query = "insert into user values('$id','$fn','$ln','$ad','$em')";
            $result = mysqli_query($con, $query);
            if ($result)
                echo "User is registered succesfully... User ID: " . $id;
            else
                echo "Registeration failed: " . mysqli_error($con);
        }

        mysqli_close($con);
    }}

    ?>
</body>
</html>

