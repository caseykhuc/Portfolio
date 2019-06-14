<?php
    include('user-menu.php');
    include('connect-db.php');

    if (!$_GET['id'])
        header('Location: user-menu.php');
    $id = mysqli_real_escape_string($con, $_GET['id']);

    $sql = "DELETE FROM user WHERE USER_ID = '$id'";
    mysqli_query($con, $sql);
    if (!mysqli_affected_rows($con))
        echo "User info failed to delete. " . mysqli_error($con);
    else {
            $sql = "DELETE FROM user_group WHERE 1";
            mysqli_query($con, $sql);
            $sql = "DELETE FROM groups WHERE 1";
            mysqli_query($con, $sql);
            header('Location: edit.php?id=1');
        }

    mysqli_close($con);
?>