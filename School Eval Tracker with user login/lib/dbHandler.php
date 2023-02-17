<?php
    //database info
    $db_info = 'localhost';
    $dbUsername = 'f2362896';
    $dbPassword = 'Mewtwo5#';
    $dbName = 'f2362896_test';

    //establish connection
    $db_con = new mysqli($db_info, $dbUsername, $dbPassword, $dbName);
    
    //if it doesnt connect show error
    if(!$db_con){
        die("connection failed: " . mysqli_connect_error());
    }