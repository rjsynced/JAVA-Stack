var dice = {
  sides: 6,
  roll: function () {
    rolls = [0, 0, 0, 0, 0, 0].map((x) => Math.ceil(Math.random() * 6));
    rolls.sort();
    sum = rolls[5] + rolls[4] + rolls[3];
    return sum;
  }
}

function printNumber(number) {
  var placeholder = document.getElementById('placeholder');
  placeholder.innerHTML = number;
}

var button = document.getElementById('button');

button.onclick = function() {
  var result = dice.roll();
  printNumber(result);
};