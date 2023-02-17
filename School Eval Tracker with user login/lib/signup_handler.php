<?php
    //if statement to sign up user
    if(isset($_POST["signup"])){

        //get user input to sign up user
        $uFullName = $_POST["uFullName"];
        $uEmail = $_POST["uEmail"];
        $uUsername = $_POST["username"];
        $pwd = $_POST["pwd"];
        $pwdRepeat = $_POST["pwdRepeat"];

        require_once 'functions.php';
        require_once 'dbHandler.php';

        if(emptyFields($uFullName, $uEmail, $uUsername, $pwd, $pwdRepeat)){
            header("location: ../signup.php?error=empty-fields");
            exit();
        }

        if(validEmail($uEmail) !== false){
            header("location: ../signup.php?error=email-invalid");
            exit();
        }
        
        if(pwdCheck($pwd, $pwdRepeat) !== false){
            header("location: ../signup.php?error=pwd-error");
            exit();
        }
        
        if(checkUsername($db_con, $uUsername) !== false){
            header("location: ../signup.php?error=username-error");
            exit();
        }

        addUser($db_con, $uFullName, $uUsername, $uEmail, $pwd);


    }else{
        header("location: ../signup.php");
    }