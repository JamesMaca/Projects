<?php require "view/header.php"; ?>

<h1>Upload Individual Assessment</h1>
<!-- individiual eval input form -->
<form method="post">
    Enter course Name/Code: <input type="text" name="courseName" placeholder="comp1234...">
    <br><br>
    Enter Assessment Name: <input type="text" name="evalName" placeholder="quiz1...">
    <br><br>
    Enter Date of Assement(yyyy-mm-dd): <input type="text" name="evalDate" placeholder="yyyy-mm-dd...">
    <br><br>
    Enter Time of Assement: <input type="text" name="evalTime" placeholder="00:00am...">
    <br><br>
    Enter Status of Assement(Completed/Current): <input type="text" name="evalStatus" placeholder="Completed/Current...">
    <br><br>
    <button name="submit" type="submit">Submit</button>
</form>
<?php
    require_once 'lib/functions.php';
    require_once 'lib/dbHandler.php';

    // do while loop to check and add individual assessments
    do{
        if(isset($_POST['submit'])){
            $courseName = $_POST["courseName"];
            $evalName = $_POST["evalName"];
            $evalDate = $_POST["evalDate"];
            $evalTime = $_POST["evalTime"];
            $evalStatus = $_POST["evalStatus"];
            
            if(emptyIndvUpl($courseName, $evalName, $evalDate, $evalTime, $evalStatus)){
                echo"<p>ERROR; Fill in all fields</p>";
                break;
            }

            if(checkCourseName($courseName) == false){
                echo"<p>ERROR; Course name not 8 characters long</p>";
                break;
            }

            if(checkEvalType($evalName) == false){
                echo"<p>ERROR; Not a string</p>";
                break;
            }

            if(checkStatus($evalStatus) == false){
                echo"<p>ERROR; Not Completed or Current</p>";
                break;
            }
            
            if(addEval($db_con, $courseName, $evalName, $evalDate, $evalTime, $evalStatus) == false){
                echo"<p>ERROR; Cannot add try again!</p>";
                break;
            }else{
                echo"Added!";
            }


            
        }
    }while(0);
?>

<br>
<hr>
<br>

<h1>Upload A Text File</h1>
<!-- upload text file form -->
<form method="post" enctype="multipart/form-data">
    Upload a file: <input type="file" name="file">
    <br>
    <br>
    <button type="submit" name="upload">Upload</button>
    <p>CSV file must be in following format - id, course_name, assessment_name, date, time, status[Current/Completed]</p>
    <hr>
</form>
<?php
    $dest = "data/";
    $file = $dest . basename($_FILES['file']['name']);
    $IDs = array();
    $courses = array();
    $evalType = array();
    $status = array();
    //do while to check and upload txt files
    do{
        if(isset($_POST['upload'])){

            $content = file_get_contents($_FILES['file']['tmp_name']);
            $lines = explode("\n", $content);
            
            //foreach to add like values to array to check txt file values
            foreach($lines as $l){
                $delimit = explode(',', $l);
                array_push($IDs, $delimit[0]);
                array_push($courses, $delimit[1]);
                array_push($evalType, $delimit[2]);
                array_push($status, $delimit[5]);   
            }
            
            if(checkSpecialCharacter($content) == false){
                echo "<p> ERROR; Special characters detected, please remove. </p>";
                break;
            }



            foreach ($IDs as $i) {
                if(!is_numeric($i)){
                    echo"<p>ERROR; ID not valid</p>";
                    break;
                }
            }

            foreach($courses as $c){
                if(checkCourseName($c) == false){
                    echo"<p>ERROR; Course name not 8 characters long</p>";
                    break;
                }
            }

            foreach($evalType as $e){
                if(checkEvalType($e) == false){
                    echo"<p>ERROR; Not a string</p>";
                    break;
                }
            }

            foreach($status as $s){
                if(checkStatus($s) == false){
                    echo"<p>ERROR; Not Completed or Current</p>";
                    break;
                }
            }

            //move uploaded file to data folder
            if(move_uploaded_file($_FILES['file']['tmp_name'], $file)){
                echo "<p>File upload success!</p>";
            }else{
                echo "<p>Fill not uploaded!</p>";
            }

            //foreach to add evaluations to database
            foreach($lines as $l){
                $delimit = explode(',', $l);
                addEval($db_con, $delimit[1], $delimit[2], $delimit[3], $delimit[4], $delimit[5]);
            }
            
        }
    }while(0);
?>
<?php require "view/footer.php"; ?>

