<?php
    // function to get page when an option is selected
    function getPage($pageName, $default=''){
        return $_REQUEST[$pageName] ?? $default;
    }
    //function to update assessments that are checked
    function updateEval($id, $txt_paths, $all_evals){
        //loop to interate through all the evaluations
        foreach($all_evals as $index => $quiz){
            //if statetment is assessments is Current
            if(str_contains($all_evals[$index], 'Current')){
                //foreach to iterate through the file paths to see if checked assessment is in those files and updating them to Current
                foreach ($txt_paths as $p) {
                    $temp_path = $p;
                    if(strpos(file_get_contents($temp_path), $quiz)){
                        if($quiz[0] == $id){
                            $old = $all_evals[$index];
                            $new = str_replace('Current', 'Completed', $all_evals[$index]);
                            $edit = file_get_contents($temp_path);
                            $edit = str_replace($old, $new, $edit);
                            file_put_contents($temp_path, $edit);
                        }
                    }
                }
                //esle if statetment is assessments is Complete
            }else if(str_contains($all_evals[$index], 'Completed')) {
                //foreach to iterate through the file paths to see if checked assessment is in those files and updating them to Current
                foreach ($txt_paths as $p) {
                    $temp_path = $p;
                    if(strpos(file_get_contents($temp_path), $quiz)){
                        if($quiz[0] == $id){
                            $old = $all_evals[$index];
                            $new = str_replace('Completed', 'Current', $all_evals[$index]);
                            $edit = file_get_contents($temp_path);
                            $edit = str_replace($old, $new, $edit);
                            file_put_contents($temp_path, $edit);
                        }
                    }
                }
            }
        }

    }
?>