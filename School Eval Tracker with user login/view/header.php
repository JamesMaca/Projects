<!-- start session for login -->
<?php session_start(); ?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Asignment 3</title>
    <style>
        ul{
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        li{
            display: inline;
        }
    </style>
</head>
<body>
    <nav>
        <ul>
            <li>
                <?php
                //if statement to show different menus for logged in users and signed out users
                    if(isset($_SESSION["userName"])){
                        echo"<li><a href='current.php'>Current | </a></li>";
                        echo"<li><a href='completed.php'>Completed | </a></li>";
                        echo"<li><a href='upload.php'>Upload | </a></li>";
                        echo"<li><a href='lib/logout_handler.php'>Logout</a></li>";

                    }else{
                       echo"<li><a href='login.php'>Login | </a></li>";
                       echo"<li><a href='signup.php'>Sign up</a></li>";
                    }
                ?>

            </li>
        </ul>
    </nav>
    <hr>
