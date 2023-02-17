<h1>List of Completed Assessments</h1>

<?php
    include 'evals.php'; 
    //form to display assessments with checkboxs
    echo "<form method='post'>";
        foreach ($all_evals as $quiz) {
            if(strpos($quiz, 'Completed')){
                $quiz = str_replace(',', '', $quiz);
                $quiz = str_replace('Completed', '', $quiz);
                $id = $quiz[0];
                echo "<p>$quiz<input name='all_evals[]' type='checkbox' value='$id'>";
                echo '<br>';
            }
        }

        echo '<br>';
        echo '<br>';
        echo '<input type="submit" name="update" value="Update">';
    echo "</form>";
        
    //if statement to grab checked assessments and send to updateEval function and count number of updated assessments
    if(isset($_POST['update'])){
        if(!empty($_POST['all_evals'])){    
            $number_checked = $_POST['all_evals'];
            $count = count($number_checked);
            echo "$count updated assessments";
            foreach($_POST['all_evals'] as $id){
                updateEval($id, $txt_paths, $all_evals);
            }
        }
    }
    echo '<hr>';
    echo "Footer <br>"
?>
<?php //echo show_source(__FILE__);?>
