<?php
//------------------SIGNUP FUCNTIONS-----------------------------------------------------------------
    //check if empty fields
    function emptyFields($uFullName, $uEmail, $uUsername, $pwd, $pwdRepeat){
        $isEmpty;
        if(empty($uFullName) || empty($uEmail) ||empty($uUsername) ||empty($pwd) ||empty($pwdRepeat)){
            $isEmpty = true;
        }else{
            $isEmpty = false;
        }
        return $isEmpty;
    }



    
    //check if email is valid
    function validEmail($uEmail){
        $isValid;
        if(!filter_var($uEmail, FILTER_VALIDATE_EMAIL)){
            $isValid = true;
        }else{
            $isValid = false;
        }
        return $isValid;
    }

    //check if passwords match and are greater then 8 letters long
    function pwdCheck($pwd, $pwdRepeat){
        if(strlen($pwd) > 8){
            $match;
            if($pwd !== $pwdRepeat){
                $match = true;
            }else{
                $match = false;
            }
            return $match;
        }

    }

    //check if username is valid and exists
    function checkUsername($db_con, $uUsername){
        if(strlen($uUsername) >= 4 && strlen($uUsername) <= 8){
            $query = "SELECT * FROM f2362896_test.users;";
            $result = $db_con -> query($query);
            while($row = $result -> fetch_assoc()){
                $username = $row['uName'];
                if($username == $uUsername){
                    return $row;

                }else{
                    $result = false;
                    return $result;
                }
            }
        }
    }

    //function to add user to database
    function addUser($db_con, $uFullName, $uUsername, $uEmail, $pwd){
        $query = "INSERT INTO f2362896_test.users (fullName, email, uName, pwd) VALUES (?, ?, ?, ?);";
        $statement = $db_con -> prepare($query);
        $statement->bind_param("ssss", $uFullName, $uEmail, $uUsername, $pwd);
        if($statement -> execute() == false){
            header("location: ../signup.php?error=cannot-execute");
            exit();
        }
        header("location: ../signup.php?error=none");
        exit();

    }

//------------------LOGIN FUCNTIONS-----------------------------------------------------------------

    //check if loging text fields are empty
    function emptyLogin($loginName, $pwd){
        if(empty($loginName) || empty($pwd)){
            $isEmpty = true;
        }else {
            $isEmpty = false;
        }
        return $isEmpty;
    }

    //login user function
    function loginUser($loginName, $loginPwd, $db_con){
        $query = "SELECT * FROM f2362896_test.users;";
        $result = $db_con -> query($query);
        while($row = $result -> fetch_assoc()){
            $username = $row['uName'];
            $email = $row['email'];
            $pwd = $row['pwd'];
            if($pwd == $loginPwd && ($loginName == $username || $loginName == $email)){
                session_start();
                $_SESSION['uID'] = $row['userID'];
                $_SESSION['userName'] = $row['uName'];
                header("location: ../current.php");
                exit();
            }else{
                header("location: ../login.php?error=wrong-login");
                exit();
            }
        }
    }

//------ASSEMENTS FUCNTIONS-------------------------------------------------------------------------

    //Add assessments to database
    function addEval($db_con, $courseName, $qName, $qDate, $qTime, $qStatus){
        $query = "INSERT INTO f2362896_test.assessments (courseName, qName, qDate, qTime, qStatus) VALUES (?, ?, ?, ?, ?);";
        $statement = $db_con -> prepare($query);
        $statement->bind_param("sssss", $courseName, $qName, $qDate, $qTime, $qStatus);
        if($statement -> execute() == false){
            return false;
            exit();
        }else{
            return true;
        }
    }

    //update checked evaluations from complete to current
    function updateComplete($db_con, $qID){
        $query = "UPDATE f2362896_test.assessments SET qStatus = 'Current' WHERE qID = ?;";
        $statement = $db_con -> prepare($query);
        $statement->bind_param("s", $qID);
        if($statement -> execute() == false){
            exit();
        }
    }
    //update checked evaluations from current to complete
    function updateCurrent($db_con, $qID){
        $query = "UPDATE f2362896_test.assessments SET qStatus = 'Completed' WHERE qID = ?;";
        $statement = $db_con -> prepare($query);
        $statement->bind_param("s", $qID);
        if($statement -> execute() == false){
            exit();
        }
    }

//------UPLOAD VALIDATION FUCNTIONS-------------------------------------------------------------------------

    //check upload file for special characters
    function checkSpecialCharacter($content){
        if(strpos($content, '<') || strpos($content, '*') || strpos($content, '>') || strpos($content, '?')){
            // echo "<p> ERROR; Special characters detected, please remove. </p>";
            return false;
        }else{
            return true;
        }
    }

    //check the course name for 8 letters
    function checkCourseName($c){
        if(strlen($c) != 8){
            return false;
        }else{
            return true;
        }
    }

    //check evaluation type to make sure it is a string
    function checkEvalType($e){
        if(!is_string($e)){
            return false;
        }else{
            return true;
        }
    }

    //check status of evaluation for complete and current
    function checkStatus($s){
        $com = "Completed";
        $curr = "Current";
        if($s == $com || $s == $curr){
            return true;
        }else{  
            return false;
        }
    }

//------INDIVIDUAL UPLOADS-------------------------------------------------------------------------

    //check if individual input fields are empty
    function emptyIndvUpl($courseName, $evalName, $evalDate, $evalTime, $evalStatus){
        $isEmpty;
        if(empty($courseName) || empty($evalName) ||empty($evalDate) ||empty($evalTime) ||empty($evalStatus)){
            $isEmpty = true;
        }else{
            $isEmpty = false;
        }
        return $isEmpty;
    }