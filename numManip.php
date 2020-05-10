<?php
//set default values
$number1 = 78;
$number2 = -105.33;
$number3 = 0.0049;
$message = 'Enter some valid numbers and click on the Submit button.';

//process
$action = filter_input(INPUT_POST, 'action');
switch ($action) {
    case 'process_data':
        $number1 = filter_input(INPUT_POST, 'number1');
        $number2 = filter_input(INPUT_POST, 'number2');
        $number3 = filter_input(INPUT_POST, 'number3');

        // make sure the user enters three numbers
        for ($i = 0; $i < strlen($number1); $i++) {
            if (ord(substr($number1, $i, 1)) > 57 || ord(substr($number1, $i, 1)) < 44 || ord(substr($number1, $i, 1)) === 47) {
                $message = "The first number is not valid";
            }
        }
        for ($i = 0; $i < strlen($number2); $i++) {
            if (ord(substr($number2, $i, 1)) > 57 || ord(substr($number2, $i, 1)) < 44 || ord(substr($number2, $i, 1)) === 47) {
                $message = "The second number is not valid";
            }
        }
        for ($i = 0; $i < strlen($number3); $i++) {
            if (ord(substr($number3, $i, 1)) > 57 || ord(substr($number3, $i, 1)) < 44 || ord(substr($number3, $i, 1)) === 47) {
                $message = "The third number is not valid";
            }
        }

        // make sure the numbers are valid
        $number1 = (float) $number1;
        $number2 = (float) $number2;
        $number3 = (float) $number3;

        // get the ceiling and floor for $number2
        $number2_ceil = ceil($number2);
        $number2_floor = floor($number2);

        // round $number3 to 3 decimal places
        $number3_rounded = round($number3, 3);

        // get the max and min values of all three numbers
        $max = max($number1, $number2, $number3);
        $min = min($number1, $number2, $number3);

        // generate a random integer between 1 and 100
        $random = random_int(1, 100);

        // format the message
        // $message = "This page is under construction.\n" .
        //            "Please write the code that processes the data.";
        if (strpos($message, 'The') !== 0) {

        $message =
            "Number 1: $number1\n" .
            "Number 2: $number2\n" .
            "Number 3: $number3\n" .
            "\n" .
            "Number 2 ceiling: $number2_ceil\n" .
            "Number 2 floor: $number2_floor\n" .
            "Number 3 rounded: $number3_rounded\n" .
            "\n" .
            "Min: $min\n" .
            "Max: $max\n" .
            "\n" .
            "Random: $random\n";
        }
        break;
}
include 'number_tester.php';
?>