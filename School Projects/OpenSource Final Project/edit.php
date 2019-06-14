<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
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
    include('user-menu.php');
    include('connect-db.php');

    if (!$_GET['id'])
        header('Location: user-menu.php');
    $id = $_GET['id'];
    echo "<h3>EDIT ID: " . $id . "</h3>";

    if (isset($_POST['submit'])) {
        $info = getInfo($con);
        if (!validateForm($info)) {
            echo '<h4 class="error">Please fill at least 1 field.<br></h4>';
        } else {
            // Check Registration Info
            //------------------------
            edit($info, $id, $con);
        }
    }

    if (isset($_POST['back'])) {
        header('Location: admin-portal.php');
    }

    if (isset($_POST['add'])) {
        $info = getInfo($con);
        if (empty($info['fname']) || empty($info['lname']) || empty($info['email']) || empty($info['addr']) )
            echo '<h4 class="error">Please fill all the fields.</h4>';
        else
            add($info, $con, $id);
    }

    function getInfo($con) {
        // Get Registration Info
        $info['fname'] = mysqli_real_escape_string($con, $_POST['fname']);
        $info['lname'] = mysqli_real_escape_string($con, $_POST['lname']);
        $info['email'] = mysqli_real_escape_string($con, $_POST['email']);
        $info['addr'] = mysqli_real_escape_string($con, $_POST['addr']);
        return $info;
    }

    function validateForm($info) {
        if (!$info['fname'] && !$info['lname'] && !$info['email'] && !$info['addr']) return false;
        return true;
    }

    function edit($info, $id, $con) {
        if (!exist($id, $con)) {
            add($info, $con, $id);
        } else {
            editField("firstname", $info['fname'], $id, $con);
            editField("lastname", $info['lname'], $id, $con);
            editField("email", $info['email'], $id, $con);
            editField("address", $info['addr'], $id, $con);
        }
    }

    function editField($column, $value, $id, $con) {
        if ($value != '') {
            $query = "Update user Set $column = '". $value . "' where user_id = ". $id;
            mysqli_query($con, $query);
            if (!mysqli_affected_rows($con))
                echo '<h4 class="error">Enter another value.</h4>' . mysqli_error($con);
            else
                header("Refresh:0");
        }
    }

    function add($info, $con, $id) {
        //create user id
        while (true) {
            $id = rand(1, 999999);
            $query = "select * from user where user_id = $id";
            $result = mysqli_query($con, $query);
            if (mysqli_num_rows($result) == 0)
                break;
        }

        insert($id, $info['fname'], $info['lname'], $info['email'], $info['addr'], $con);
    }

    function insert($id, $fn, $ln, $em, $ad, $con) {
        $query = "insert into user (user_id, firstname, lastname, email, address) values('$id','$fn','$ln','$em','$ad')";
        $result = mysqli_query($con, $query);
        if (!$result)
            echo "User info failed to update. " . mysqli_error($con);
        else
            header("Refresh:0");
    }

    function exist($id, $con) {
        $query = "SELECT count(*) FROM user WHERE USER_ID = '$id'";
        $row = mysqli_fetch_row(mysqli_query($con, $query));
        if (!$row[0])
            return false;
        return true;
    }

    mysqli_close($con);
?>
<form method="post" class="small-width">
    First Name: <input type ='text' name="fname" > <br><br>
    Last Name: <input type ='text' name="lname" > <br><br>
    Address: <input type ='text' name="addr" > <br><br>
    Email: <input type ='text' name="email" > <br><br>
    <div class="small-button-linear">
        <input type ="submit" value="Add" name="add"/>
        <input type ="submit" value="Edit" name="submit"/>
        <input type ="submit" value="Back" name="back"/>
    </div>
</form>
</body>
</html>