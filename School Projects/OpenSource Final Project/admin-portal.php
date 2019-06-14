<?php
    session_start();

    if (!$_SESSION['username']) {
        header('Location: admin-login.php');
    }

    if (isset($_POST['log-out'])) {
        logout();
    }

    function logout() {
        session_destroy();
        header('Location: admin-login.php');
    }
?>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Portal</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form method="post" action="">
    <header>Hackathon Team Management</header>
    <nav>
        <ul>
            <li><a href="register-user.php">User Registration</a></li>
            <li><a href="user-login.php">User Login</a></li>
            <li><a href="admin-login.php">Admin Login</a></li>
            <li><a href="upload.html">File Upload</a></li>
        </ul>
    </nav>
    <br><br>
    <h2 class="center-text">Admin View</h2>
    <div class="button-linear">
        <a class="a-ktt" href="edit.php?id=1">View/Edit Users Account</a><br>
        <a class="a-ktt" href="create-group.php">Create Group</a><br>
        <input type="submit" name="log-out" value="Log Out">
    </div>
</form>
</body>
</html>