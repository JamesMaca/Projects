<h1>Upload Assessments File</h1>

<!-- form to display buttons to upload a file -->
<form method="post" enctype="multipart/form-data">
    Upload a file: <input type="file" name="file">
    <br>
    <br>
    <button type="submit" name="submit">Upload</button>
    <p>CSV file must be in following format - id, course_name, assessment_name, date, time, status[Current/Completed]</p>
</form>

<br><hr>

<?php
    //php script to get uploaded file path and mode to data directory
    $fileFullPath = $_FILES["file"]["full_path"];
    $destination = dirname(__DIR__, 1) . '/data/' . $fileFullPath;
    move_uploaded_file($_FILES['file']['tmp_name'], $destination);
    
    echo '<h3>Files Previously Uploaded</h3>';
    $data_names = preg_grep('/^([^.])/', scandir($path['DATA_PATH']));
    echo "<nav>";
        echo "<ul>";
            foreach ($data_names as $file_name) {
                echo "<li><a href=''>$file_name</a></li> <br>";
            }
        echo "</ul>";
    echo "</nav>";
    
?> 
<hr>
<?php 
    echo "Footer <br>";
    echo show_source(__FILE__);
?>
