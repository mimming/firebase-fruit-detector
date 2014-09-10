var five = require("johnny-five");
var Firebase = require("firebase");

var board = new five.Board();
var myFirebaseRef = new Firebase("https://test-firebase-please-ignore.firebaseio.com/fruitdetector");

board.on("ready", function() {
  var fruit = new five.Sensor({
    pin: "A2",
    freq: 250
  });

  board.repl.inject({
    sensor: fruit
  });

  fruit.scale([0, 1024]).on("data", function() {
    var voltage = this.raw / 1024 * 5;
    var fruitType = "unknown";
    if(this.raw < 20) {
      fruitType = "none";
    } else if(this.raw >= 20 && this.raw < 92) {
      fruitType = "orange";
    } else if(this.raw >= 92 ) {
      fruitType = "apple";
    }    
    myFirebaseRef.set({"type":fruitType, "voltage":voltage});
    console.log(this.raw, voltage, fruitType);
  });
});
