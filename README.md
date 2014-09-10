# Firebase Fruit Detector
An Arduino / Raspberry Pi fruit detector that uses Firebase to power web, Google Glass and Android displays.

v0.1 supports apples and oranges.

## What's here
This project contains 4 directories:
 - `/detector` - The node.js code for the fruit detector
 - `/android` - An android app to read the detected fruit
 - `/web` - A tiny web app to read the detected fruit
 - `/google-glass` - A Google Glass app to read the detected fruit

## The Fruit Detector
This probably works with other boards, but it was written with two things you probably have lying around somewhere. Go dig them up and blow the dust off of them.

- Raspberry pi
- Arduino Uno
- Jumper wires, and a resistor
- Something copper, something zinc (A crew and a piece of wire work great)

### Soft dependencies

- [Firebase](https://www.firebase.com/) - realtime platform; the Internet part of this example
- [Johnny Five](https://github.com/rwaldron/johnny-five#user-content-setup-and-assemble-arduino) - open source JavaScript Arduino programming framework

### Running it
0. Add a pull down resistor to A3. Ground the zinc probe. Connect the copper probe to the A3.
0. Install the `StandardFirmata` sketch to your Arduino per the [Johnny Five documentation](https://github.com/rwaldron/johnny-five#user-content-setup-and-assemble-arduino).
0. Install [node.js](http://nodejs.org/), [Johnny Five](https://github.com/rwaldron/johnny-five#user-content-hey-you-heres-johnny) and [Firebase's node.js client](https://www.firebase.com/docs/web/quickstart.html) onto your Raspberry Pi.
0. Create a new [Firebase](https://www.firebase.com/) to store/synchronize your state. Replace `test-firebase-please-ignore` in the code with the subdomain for your Firebase.
0. Copy the JavaScript code on to your Raspberry Pi.
0. Run it:

        $ node device/fruit-detector.js

0. Stab the probes into your fruit.


