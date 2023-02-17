<?php include_once 'view/header.php'; ?>
<h1>Login</h1>
<!-- form to login user -->
<form action="lib/login_handler.php" method="post">
    Enter username or email: <input type="text" name="loginName" placeholder="Username/Email...">
    <br>
    Password: <input type="password" name="loginPwd" placeholder="Password...">
    <br>
    <button name="login" type="submit">Log In</button>
</form>
<?php
    // if statement to show user error
    if(isset($_GET["error"])){
        if($_GET["error"] == "empty-fields"){
            echo "<p>Fill in all fields!</p>";
        }
        if($_GET["error"] == "wrong-login"){
            echo "<p>Username is Wrong!</p>";
        }
    }
?>

<?php require "view/footer.php"; ?>