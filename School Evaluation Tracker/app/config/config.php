
<?php
    //array to holds paths to other files in the app
    $path = [
        'MODEL_PATH' => APP_PATH . DS . 'model' . DS,
        'VIEW_PATH' => APP_PATH . DS . 'view' . DS,
        'LIB_PATH' => APP_PATH . DS . 'lib' . DS,
        'DATA_PATH' => APP_PATH . DS . 'data' . DS
    ];

    //requre functions.php
    require $path['LIB_PATH'] . 'functions.php';