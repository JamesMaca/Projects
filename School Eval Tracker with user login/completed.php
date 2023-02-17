<?php require "view/header.php"; ?>

<h1>Completed Assements/h1>
<!-- current assessments checklist -->

<form action="" method='post'>
        <?php
            require_once 'lib/functions.php';
            require_once 'lib/dbHandler.php';
            //query and while loop to get evals and print them with a checkbox
            $query = "SELECT * FROM f2362896_test.assessments where qStatus = 'Completed';";
            $stmt = $db_con->query($query);
            while($completedEvals = $stmt -> fetch_assoc()){
                $qID = $completedEvals['qID'];
                $courseName = $completedEvals['courseName'];
                $qName = $completedEvals['qName'];
                $qDate = $completedEvals['qDate'];
                $qTime = $completedEvals['qTime'];
                $qStatus = $completedEvals['qStatus'];
                echo "<p> $qID $courseName $qName $qTime $qStatus <input name=completedEvals[] type='checkbox' value='$qID'>";
            }
        ?>
        <br><br>
    <input type="submit" name="update" value="Update">   
</form>

<?php
    //if statement to count number of checked evals and update it

    if(isset($_POST['update'])){
        if(!empty($_POST['completedEvals'])){
            $checked = $_POST['completedEvals'];
            $count = count($checked);
            echo "$count updated assessments";
            foreach ($_POST['completedEvals'] as $eval) {
                updateComplete($db_con, $eval);
            }
        }
    }
    
?>
<?php require "view/footer.php"; ?>