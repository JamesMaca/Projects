
<?php
    //path to get all data files
    $data = preg_grep('/^([^.])/', scandir($path['DATA_PATH']));
    //array to store all assessments
    $all_evals = [];
    //hold all the paths to the txt files uploaded
    $txt_paths = [];
    
    //foreach loop to interate through $data and fill $all_evals and $txt_paths accordingly
    foreach($data as $file){
        $tempPaths = $path['DATA_PATH'] . $file;
        array_push($txt_paths, $tempPaths);
        $temp = file($tempPaths);
        foreach($temp as $e){
            array_push($all_evals, $e);
        }   
    }
    // print_r($all_evals);
    // echo show_source(__FILE__);
?>
