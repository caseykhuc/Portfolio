<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Menu</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<?php
    session_start();

    if (!$_SESSION['username']) {
        header('Location: admin-login.php');
    }

    include('connect-db.php');
    $userNum = 0;
    printUsers($con, $userNum);

    function printUsers($con, $userNum) {
        $query = "Select * from user";
        $result = mysqli_query($con, $query) or die ("query is failed" . mysqli_error($con));
        echo "<h3>User List</h3>";
        echo "<table border='1' align='center' cellpadding='3'>";
        echo "<tr><th>ID</th><th>Firstname</th><th>Lastname</th><th>Address</th><th>Email</th><th>Edit</th><th>Delete</th></tr>";

        // display the user table
        while ($row = mysqli_fetch_row($result)) {
            $userNum = $userNum + 1;
            echo '<tr>';
            echo '<td>'.$row[0].'</td>';
            echo '<td>'.$row[1].'</td>';
            echo '<td>'.$row[2].'</td>';
            echo '<td>'.$row[3].'</td>';
            echo '<td>'.$row[4].'</td>';
            echo '<td><a class="edit-btn" href="edit.php?id=' . $row[0] . '">Edit</a></td>';
            echo '<td><a class="delete-btn" href="delete.php?id=' . $row[0] . '">Delete</a></td>';
            echo '</tr>';
        }
        echo "</table><br>";
    }

    mysqli_close($con);
?>

<!--<a href="new.php">Add new User</a>-->

</body>
</html>
