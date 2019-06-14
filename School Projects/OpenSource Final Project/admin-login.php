<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
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
<form class="small-width" method="post" action="">
    <h2 class="center-text">Admin Login</h2>
    <p><label>Username: </label><input type="text" name="username"/></p>
    <p><label>Password: </label><input type="password" name="password"/></p>
    <div class="small-button-linear">
        <input type="submit" name="login" value="Log In" />
        <input type="submit" name="back" value="Back"><br>
    </div>
</form>
<?php
    session_start(); // Create a Session

    if(isset($_POST["login"])){
        if(!empty($_POST['username']) && !empty($_POST['password'])){
            include('connect-db.php');

            $user = mysqli_real_escape_string($con, $_POST['username']);
            $pass = mysqli_real_escape_string($con, $_POST['password']);

            $query = "SELECT 'Username', 'Password' FROM admin WHERE Username= '$user' AND Password='$pass'";
            $result = mysqli_query($con, $query)
                or die("Query failed ".mysqli_error($con));

            if(mysqli_num_rows($result) > 0){
                echo "Login success!";
                $_SESSION['username'] = $user;
                header('location:admin-portal.php');
                exit();
            }else{
                echo "<h3>Login failed!</h3>";
            }
        } else {
            echo 'Please input an username and password.';
        }
    }

    if (isset($_POST["back"])) {
        header('location:index.html');
        exit();
    }
?>


</body>
</html>
<style>
    form {
        margin-top: 100px!important;
    }
</style>