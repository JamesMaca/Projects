<?php
    //if statement to login user
    if(isset($_POST["login"])){

        //get user input to login the user
        $loginName = $_POST["loginName"];
        $loginPwd = $_POST["loginPwd"];

        require_once 'functions.php';
        require_once 'dbHandler.php';

        if(emptyLogin($loginName, $loginPwd) !== false){
            header("location: ../login.php?error=empty-fields");
            exit();
        }

        loginUser($loginName, $loginPwd, $db_con);

    }else{
        header("location: ../login.php");
        exit();
    }