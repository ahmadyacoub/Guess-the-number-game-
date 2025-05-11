Number Guessing Game - Android Application
Overview
This Android application is an engaging number guessing game designed to provide an interactive and fun user experience. The application prompts users to input their personal details and then challenges them to guess a randomly generated target number between 1 and 100. The game provides feedback through a binary search mechanism, guiding users to the correct number with visual and notification-based cues.
Features


https://github.com/user-attachments/assets/0edac041-ce7a-4c62-a9fc-4a7a0f4b1d54



https://github.com/user-attachments/assets/8c4c8e27-3369-48e6-aff1-8a9ec8c16660


User Input Form: Collects the player's first name, last name, and gender via a user-friendly interface.
Input Validation: Ensures valid input by checking for non-empty names, non-numeric names, and gender selection.
Interactive Gameplay: Players guess the target number using "Lower," "Higher," or "Equal" buttons, with real-time feedback:
Green background for correct guesses.
Red background for incorrect guesses.
Toast messages to indicate correct or incorrect actions.


Binary Search Logic: Adjusts the displayed number based on user input, narrowing the range with each guess.
Push Notifications: Displays the target number via a notification at the start of the game.
Responsive UI: Clean and intuitive interface with consistent button styling using a custom purple color (#673AB7FF).
Game Reset: Automatically redirects to the input screen upon a correct guess, allowing for replayability.

Technical Details

Platform: Android
Language: Java
Minimum API Level: API 26 (Android 8.0 Oreo) for notification channel support
Key Libraries:
AndroidX for modern Android app development
NotificationCompat for cross-version notification compatibility


Key Components:
MainActivity.java: Handles user input, validation, and navigation to the game page.
game_page.java: Manages game logic, UI updates, notifications, and user interactions.


Layouts:
activity_main.xml: Input form with EditText fields, Spinner, and a start button.
activity_game_page.xml: Game interface with TextViews for welcome message and number display, and buttons for gameplay.



How to Play

Enter Details: Provide your first name, last name, and select a gender from the dropdown.
Start the Game: Click the "Start Game" button to proceed. Ensure all fields are valid to avoid error messages.
Guess the Number:
A random target number (1–100) is generated and shown in a notification.
The game displays a current number (initially 50).
Use the "Lower" button if you think the target is smaller, "Higher" if larger, or "Equal" if you believe the current number is correct.


Feedback:
Correct guesses turn the clicked button green and display a "Correct!" message.
Incorrect guesses turn the button red and show a "WRONG!" message.
The current number updates based on your input, narrowing the range.


Winning: Selecting "Equal" when the current number matches the target ends the game and returns you to the input screen.

Installation

Clone the Repository:git clone https://github.com/ahmadyacoub/Guess-the-number-game-.git


Open in Android Studio:
Import the project into Android Studio.
Ensure the Android SDK is configured for API 26 or higher.


Build and Run:
Sync the project with Gradle.
Run the app on an emulator or physical device running Android 8.0 or later.



Project Structure
number-guessing-game/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/todo1/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── game_page.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── activity_game_page.xml
│   │   │   │   ├── mipmap/
│   │   │   │   │   ├── ic_launcher.png
│   ├── build.gradle
├── README.md

Dependencies

AndroidX Core
AndroidX AppCompat
AndroidX NotificationCompat

Add the following to your app/build.gradle:
dependencies {
    implementation 'androidx.core:core:1.12.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'androidx.core:core:1.12.0'
}

Screenshots
(To be added: Screenshots of the input screen, game page, and notification.)
Future Enhancements

Add a scoring system based on the number of guesses.
Implement difficulty levels (e.g., wider number range or limited guesses).
Enhance UI with animations for button presses and transitions.
Store high scores locally using SharedPreferences.
Support multiple languages for broader accessibility.

Contributing
Contributions are welcome! Please follow these steps:

Fork the repository.
Create a new branch (git checkout -b feature/your-feature).
Commit your changes (git commit -m 'Add your feature').
Push to the branch (git push origin feature/your-feature).
Open a pull request with a detailed description of your changes.

License
This project is licensed under the MIT License. See the LICENSE file for details.
Contact
For questions or feedback, please reach out via GitHub Issues or contact the project maintainer at [your-email@example.com].

Built with ❤️ by [Ahmad Ismail]





