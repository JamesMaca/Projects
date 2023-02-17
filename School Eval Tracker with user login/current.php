<?php require "view/header.php"; ?>

<h1>Current Assements</h1>
<!-- current assessments checklist -->
<form action="" method='post'>
    <?php
        require_once 'lib/functions.php';
        require_once 'lib/dbHandler.php';
        //query and while loop to get evals and print them with a checkbox
        $query = "SELECT * FROM f2362896_test.assessments where qStatus = 'Current';";
        $stmt = $db_con->query($query);
        while($currentEvals = $stmt -> fetch_assoc()){
            $qID = $currentEvals['qID'];
            $courseName = $currentEvals['courseName'];
            $qName = $currentEvals['qName'];
            $qDate = $currentEvals['qDate'];
            $qTime = $currentEvals['qTime'];
            $qStatus = $currentEvals['qStatus'];
            echo "<p> $qID $courseName $qName $qTime $qStatus <input name=currentEvals[] type='checkbox' value='$qID'>";
        }
    ?>   
        <br><br>
    <input type="submit" name="update" value="Update">   
</form>
<?php
    //if statement to count number of checked evals and update it
    if(isset($_POST['update'])){
        if(!empty($_POST['currentEvals'])){
            $checked = $_POST['currentEvals'];
            $count = count($checked);
            echo "$count updated assessments";
            foreach ($_POST['currentEvals'] as $eval) {
                updateCurrent($db_con, $eval);
            }
        }
    }
?>
<?php require "view/footer.php"; ?>