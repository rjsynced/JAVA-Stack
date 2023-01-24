var dice = {
  sides: 20,
  roll: function () {
    var randomNumber = Math.floor(Math.random() * this.sides) + 1;
    return randomNumber;
  }
}



//dice roll 1 STR

function printNumber(number) {
  var placeholder = document.getElementById('str');
  if(number == 20) {
	  placeholder.innerHTML = "*** NAT " + number + " ***";
  } else {
	  placeholder.innerHTML = "You rolled a " + number;
  }
}

var button = document.getElementById('button');

button.onclick = function() {
  var result = dice.roll();
  printNumber(result);
};

// dice roll 2 CON
function printNumber1(number) {
  var placeholder = document.getElementById('con');
  if(number == 20) {
	  placeholder.innerHTML = "*** NAT " + number + " ***";
  } else {
	  placeholder.innerHTML = "You rolled a " + number;
  }
}

var button = document.getElementById('button1');

button.onclick = function() {
  var result = dice.roll();
  printNumber1(result);
};

// dice roll 3 DEX
function printNumber2(number) {
  var placeholder = document.getElementById('dex');
  if(number == 20) {
	  placeholder.innerHTML = "*** NAT " + number + " ***";
  } else {
	  placeholder.innerHTML = "You rolled a " + number;
  }
}

var button = document.getElementById('button2');

button.onclick = function() {
  var result = dice.roll();
  printNumber2(result);
};

// dice roll 4 INT
function printNumber3(number) {
  var placeholder = document.getElementById('int');
  if(number == 20) {
	  placeholder.innerHTML = "*** NAT " + number + " ***";
  } else {
	  placeholder.innerHTML = "You rolled a " + number;
  }
}

var button = document.getElementById('button3');

button.onclick = function() {
  var result = dice.roll();
  printNumber3(result);
};

// dice roll 5 WIS
function printNumber4(number) {
  var placeholder = document.getElementById('wis');
  if(number == 20) {
	  placeholder.innerHTML = "*** NAT " + number + " ***";
  } else {
	  placeholder.innerHTML = "You rolled a " + number;
  }
}

var button = document.getElementById('button4');

button.onclick = function() {
  var result = dice.roll();
  printNumber4(result);
};

// dice roll 6 CHA
function printNumber5(number) {
  var placeholder = document.getElementById('cha');
  if(number == 20) {
	  placeholder.innerHTML = "*** NAT " + number + " ***";
  } else {
	  placeholder.innerHTML = "You rolled a " + number;
  }
}

var button = document.getElementById('button5');

button.onclick = function() {
  var result = dice.roll();
  printNumber5(result);
};

