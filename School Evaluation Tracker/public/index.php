<?php
    //creating constants
    define('APP_PATH', realpath(dirname(__FILE__) . '/../app'));
    const DS = DIRECTORY_SEPARATOR;

    //require config file
    require APP_PATH . DS . 'config' . DS . 'config.php';

    //creating variables for paths
   $page = getPage('page', 'current');
   $model = $path['MODEL_PATH'] . $page . '.php';
   $view = $path['VIEW_PATH'] . $page . '.php';

   include $path['VIEW_PATH'] . 'layout.phtml';

   //making current.php the landing page
   if(file_exists($model)){
       require $model;
   }

?>