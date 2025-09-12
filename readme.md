📖 OldPhonePad

OldPhonePad is a Java project that simulates the behavior of old-style mobile phone keypads (like Nokia T9). It allows users to input sequences of numbers, spaces, and special characters (* for backspace, # for send) and outputs the corresponding text.

This project is designed using OOP principles, ensuring clean architecture, extensibility for multiple phone pad types in the future, and testability.

**Features**:

* Supports multiple presses of keys to select the desired character.
* 
* Supports backspace (*) to delete the last typed character.
* 
* Supports pauses ( ) to type consecutive characters from the same key.
* 
* Sends output on # (end of input).
* 
* Easily extensible to support multiple phone pad types.



**Running Tests**

To run the tests, use the following command in the terminal:
```
./gradlew test
```
**Tests cover:**
* Single and multiple key presses
* Backspace functionality
* Handling of spaces (pause)
* Edge cases like empty input and only #


