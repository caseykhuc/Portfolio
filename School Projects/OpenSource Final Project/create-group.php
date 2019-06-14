<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Group</title>
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
?>
    <form class="small-width" method="post" action="">
        Group Size: <input type="text" name="group-size"/><br><br>
        <div class="small-button-linear">
            <input type="submit" name="create" value="Create Group" />
            <input type ="submit" name="back" value="Back"/>
        </div>
    </form>
<?php
    if (isset($_POST['create'])) {
        $size = $_POST['group-size'];

        $sql = "SELECT * FROM user";
        $result = mysqli_query($con, $sql);
        $userNum = mysqli_num_rows($result);

        if (!validateSize($size, $userNum)) {
            echo '<h4 class="error">Please enter proper group size.<br></h4>';
        } else {
            // Divide users into groups
            //------------------------

            // data to array
            $info = array();
            while ($data = mysqli_fetch_array($result)) {
                $info[] = $data;
            }

            // randomly assign to groups
            shuffle($info);
            $groupNum = intval($userNum/$size);
            $waiting = $userNum % $size;

            // -----
            $sql = "DELETE FROM groups WHERE 1";
            mysqli_query($con, $sql);
            for ($x = 1; $x <= $groupNum; $x++) {
                $gr = mysqli_real_escape_string($con, strval($x));
                $sql = "INSERT INTO groups VALUES('$gr', 'Group $gr')";
                mysqli_query($con, $sql) or die ("query is failed" . mysqli_error($con));

                for ($y = 0; $y < $size; $y++) {
                    $user_id = mysqli_real_escape_string($con, strval($info[$size*($x-1)+$y][0]));
                    $group_id = mysqli_real_escape_string($con, strval($x));
                    $sql = "INSERT INTO user_group VALUES('$user_id', '$group_id')";
                    //echo $sql."<br>";
                    mysqli_query($con, $sql);
                }
            }

            if ($waiting) {
                //echo "Waiting: ".$waiting."<br>";
                $groupNum++;
                $gr = mysqli_real_escape_string($con, strval($groupNum));
                $sql = "INSERT INTO groups VALUES('$gr', 'Group $gr')";
                mysqli_query($con, $sql) or die ("query is failed" . mysqli_error($con));

                for ($x = 1; $x <= $waiting; $x++) {
                    $user_id = mysqli_real_escape_string($con, strval($info[$userNum-$x][0]));
                    $group_id = mysqli_real_escape_string($con, strval($groupNum));
                    //echo $user_id."<br>";
                    //echo $group_id."<br>";
                    $sql = "INSERT INTO user_group VALUES('$user_id', '$group_id')";
                    //echo $sql."<br>";
                    mysqli_query($con, $sql);
                }
            }

            for ($x = 1; $x <= $groupNum; $x++) {
                printGroup($con, $x, $size);
            }
        }
    }

    if (isset($_POST['back'])) {
        header('Location: admin-portal.php');
    }

    function validateSize($size, $userNum) {
        if ($size < 1) return false;
        if ($size > $userNum) return false;
        return true;
    }

    function printGroup($con, $gr, $size) {
        echo "<h3>GROUP $gr:</h3>";
        $sql = "SELECT * FROM user u 
                JOIN user_group ug 
                ON u.USER_ID = ug.USER_ID 
                WHERE ug.GROUP_ID = $gr";
        //echo $sql;
        $result = mysqli_query($con, $sql) or die ("query is failed" . mysqli_error($con));
        $grSize = mysqli_num_rows($result);
        if ($grSize < $size) {
            echo "<h4 class='error'>Not verified, waiting for more people</h4>";
        }

        echo "<table border='1' align='center' cellpadding='3'>";
        echo "<tr><th>ID</th><th>Firstname</th><th>Lastname</th><th>Address</th><th>Email</th></tr>";

        // display the user table

        while ($row = mysqli_fetch_row($result)) {
            echo '<tr>';
            echo '<td>'.$row[0].'</td>';
            echo '<td>'.$row[1].'</td>';
            echo '<td>'.$row[2].'</td>';
            echo '<td>'.$row[3].'</td>';
            echo '<td>'.$row[4].'</td>';
            echo '</tr>';
        }
        echo "</table><br>";
    }

    mysqli_close($con);
?>

</body>
</html>
