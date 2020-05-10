//displays text stating the project name at the bottom
document.write("HTML/CSS/Javascript Calculator");

//creates an event listener for the credits button
document.getElementById("credit").addEventListener("click", credits);

//object that hold information from the pressed calculator keys
var calcFunctions =
{
	onScreen: '0', //value of on-screen display
	firstNumber: null, //value of first number clicked
	secondNumberFlag: false, //checks if second number has been clicked
	mathButtons: null //holds value for buttons with 'function' class tag
};


// displays values on calculator screen
function calcScreen()
{
	var length = 10;
	var onScreen = calcFunctions.onScreen;
	var fitsOnScreen = onScreen.substring(0, length);

	var display = document.querySelector('#calc_screen');
	display.value = fitsOnScreen;
}

calcScreen();


//Event listener for calculator buttons clicked
var pressed = document.querySelector('#calc_keys');
pressed.addEventListener('click', (event) =>
{
	var clickedButton = event.target;

	if (!clickedButton.matches('button'))
	{
		return;
	}

	//logs if operator key (+,-,*,/) is pressed
	if (clickedButton.classList.contains('function'))
	{
		mathButtonsPressed(clickedButton.value);
		calcScreen();
		return;
	}

	//logs if decimal key is pressed
	if (clickedButton.classList.contains('decimal'))
	{
		showDecimal(clickedButton.value);
		calcScreen();
		return;
	}

	//logs if clear key is pressed
	if (clickedButton.classList.contains('clear'))
	{
		reset();
		calcScreen();
		return;
	}

	displayNumbers(clickedButton.value);
	calcScreen();
});


/*
	Shows numbers on calculator display.  If the display is showing '0', it will be 
	overwritten with the button clicked.  If the display is showing anythign other
	than '0', additional button clicks will be appended to the display.  Additionally,
	if secondNumber from the calcFunctions object is true, the secondNumber value will
	overwrite the firstNumber value
*/
function displayNumbers(clickedButton)
{	
	if (calcFunctions.secondNumberFlag == true)
	{
		calcFunctions.onScreen = clickedButton;
		calcFunctions.secondNumberFlag = false;
	}
	else if (calcFunctions.onScreen == '0')
	{
		calcFunctions.onScreen = clickedButton;
	}
	else
	{
		calcFunctions.onScreen = calcFunctions.onScreen + clickedButton;
	}
}


/*
	If a button is clicked with the 'function' class tag this function checks the calculator
	display values.  If firstNumber has not been given a value, mathButtons value is null.  
	If firstNumber has been given a value, secondNumber is valued at true
*/
function mathButtonsPressed(mathButton)
{
	var firstNumber = calcFunctions.firstNumber;
	var SecNumFlag = calcFunctions.secondNumberFlag;
	var value = parseFloat(calcFunctions.onScreen);

	if (firstNumber == null)
	{
		calcFunctions.firstNumber = value;
	}

	else if (firstNumber != null && SecNumFlag == true)
	{
		calcFunctions.secondNumberFlag = false;
	}

	else if (firstNumber != null)
	{
		var result = doMath()
		calcFunctions.onScreen = String(result);
		calcFunctions.firstNumber = result;
		calcFunctions.secondNumberFlag = false;
	}

	calcFunctions.secondNumberFlag = true;
	calcFunctions.mathButtons = mathButton;
}


/*
	When this function is called, the value of calcFunctions.mathButtons is switched
	to a math operation using calcFunctions.firstNumber and the value of the second number
	which is called from calcFunctions.onScreen.  It returns the value of the math 
	operation via result.  If the second number is '0', a popup window is displayed,
	result returns the value of calcFunctions.firstNumber, and the reset function is called
*/
function doMath()
{
	var result;
	var secondNumber = parseFloat(calcFunctions.onScreen);
	var firstNumber = parseFloat(calcFunctions.firstNumber);
	
	switch (calcFunctions.mathButtons)
	{
		case '*':
			result = (firstNumber * secondNumber);
			break;

		case '-':
			result = (firstNumber - secondNumber);
			break;
				
		case '/':
			try
			{
				result = (firstNumber/secondNumber);
				if (Number.isNaN(result))
				{
					throw new Error("  You can't divide 0 by 0.");
				}
				else if (result == Infinity)
				{
					throw new Error("  You can't divide a number by 0");
				}
			}
			catch (Error)
			{
				alert(Error);
				result = "ERROR"
			}
			break;

		case '+':
			result = (firstNumber + secondNumber);
			break;
	}
	
	return result;
	
}


/*
	This function checks calculator display for decimal points.  If one does not already
	exist, a decimal will be displayed.  If one does exist, the button click will be
	ignored.
*/
function showDecimal(decimal)
{
	if (!calcFunctions.onScreen.includes(decimal))
	{
		calcFunctions.onScreen += decimal;
	}
}


/* 
	This function resets calcFunctions object values to default
*/
function reset()
{
	calcFunctions.onScreen = '0';
	calcFunctions.firstNumber = null;
	calcFunctions.secondNumberFlag = false;
	calcFunctions.mathButtons = null;
}

function credits() {
	window.alert("This project was created by Arron Pelc, David Eubank, and Joseph Summerlin");
}