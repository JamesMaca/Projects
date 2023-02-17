<?php include_once 'view/header.php'; ?>
<h1>Sign Up</h1>
<!-- sign up form -->
<form action="lib/signup_handler.php" method="post">
    Enter Full Name: <input type="text" name="uFullName" placeholder="Full name...">
    <br><br>
    Enter Email Address: <input type="text" name="uEmail" placeholder="Email...">
    <br><br>
    Create Username: <input type="text" name="username" placeholder="Username...">
    <br><br>
    Enter Password: <input type="password" name="pwd" placeholder="Password..."><br>
    Re-enter Password, must match: <input type="password" name="pwdRepeat" placeholder="Repeat password...">
    <br><br>
    <button name="signup" type="submit">Sign Up</button>
</form>
<?php
    //if statement to show users errors on sign up
    if(isset($_GET["error"])){
        if($_GET["error"] == "empty-fields"){
            echo "<p>Fill in all fields</p>";
        }else if($_GET["error"] == "email-invalid"){
            echo "<p>invalid email</p>";
        }else if($_GET["error"] == "pwd-error"){
            echo "<p>Passwords must be atleast 8 letters long or do not match</p>";
        }else if($_GET["error"] == "username-error"){
            echo "<p>Username must be between 4 and 8 letters long or already exists, choose a different one.</p>";
        }else if($_GET["error"] == "none"){
            echo "<p>You are signed up!</p>";
        }
    }
?>

<?php require "view/footer.php"; ?>