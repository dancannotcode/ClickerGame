# Viral Clicker
> Click on all the enemy widgets and watch as you level, up your account

## Table of Contents
* [Overview](#overview)
* [Demo](#demo)
* [Screenshots](#screenshots)
* [Technologies Used](#technologies-used)
* [Setup Instructions](#setup-instructions)
* [How It Works](#how-it-works)
* [Code Snippets](#code-snippets)
* [Features](#features)
* [Status](#status)
* [Contributors](#contributors)
* [Contact](#contact)

## Overview
The intended audience for this clicker game is broad, encompassing users of all ages with a slight skew towards younger players (ages 12-25) who are more inclined towards casual mobile games. With the game's simple mechanics it is perfect for those who do not want to spend too much time learning mechanics and gives the user a relaxing experience. 
## Demo
[Video Link](https://www.youtube.com/watch?v=OUK0us7isz8)

## Screenshots
this shows the colorful cover page of the app, which then prompts to either register or login. If the login doesn't exist than infrom the user of that case
<div style = {display: flex}>
  <img width="300" alt="The Cover Page of the app" src="https://github.com/user-attachments/assets/7d88af30-252a-4aa1-ac4d-e904eef47fb4">
  <img width="300" alt="The Login Page of the app. Shows what an Unsuccseful login looks like" src="https://github.com/user-attachments/assets/b18e03dd-08ad-4f1f-877a-f36328828649">
</div>
<br>
this is the gameplay for viral clicker as the enemy widgets move then the players level increases as shown in the bar. Players are also able to customize the enemy
<div style = {display: flex}>
  <img width="300" alt="The game page, and shows the widgets have moved from original position" src="https://github.com/user-attachments/assets/f1e0565b-c706-4a4c-bce7-7b0434aeaf47">
  <img width="300" alt="Shows customization page. with an edgy widget on the right and a circular widget on the left with differnt colors from the original widgets" src="https://github.com/user-attachments/assets/422dd1b0-b760-4775-878c-d30333bcd92b">
</div> 


## Technologies Used
* Java
* FireBase
* Kotlin

## Setup Instructions
1. Copy URL[https://github.com/dancannotcode/ExpenseTrackingAndroidApp.git]
2. Install [Android Stuidos](https://developer.android.com/studio)
3. Run the application
4. click on `Clone Repository`
5. Paste Repository URL[https://github.com/dancannotcode/ClicerGame.git]


## How It Works
1. Login
  * `Firebase authentication` instance to handle login and registration
  * takes in data from the users inputs in the fields
  * Attempts to log in the user with the provided email and password. On successful login, navigates to the home page fragment. On failure, shows a Toast message with the error
2. Enemies
  * Displayes enemy widgets by ID in an array to the user as well as displaying the users level bar
  * `onClickListener` is used to track which enemy is clicked on and plays a sound to alert user a click has been made
  * The enemy moves and clicks total is retrived and incremented based on clicks, then stored in the users `fireBase` based on current login
  * When Fragment is destroyed that is when we save the data to the `firebase`
3. Level Bar
  * Random XP is then attributed to the current progress bar of the user and sets it, the same way we did for enemies
  * When Fragment is destroyed that is when we save the data to the `firebase`
4. Customization 
  * Fragment for customizing enemies (appearance, name) in an Android app by ID
  * Based on the `color button` the user clicks on it customizes the color of the widget
  * Save data to `firebase` based on user ID into a virus data section


## Code Snippets
````java
private void loginUser(String email, String password) {
        //we use a Firebase function to check if the email and password are valid
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), task -> {
                    //if the password exists than the user can proceed to the game
                    if (task.isSuccessful()) {
                        Toast.makeText(getActivity(), "Authentication successful.", Toast.LENGTH_SHORT).show();
                        NavHostFragment.findNavController(LoginFragment.this)
                                .navigate(R.id.action_navigation_login_to_navigation_home);
                    }
                    //If the pasword/email doesn't exist than the user is alerted of the case
                      else {
                        Toast.makeText(getActivity(), "Authentication failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

````
<br>
<br>

````java
private void moveImage(ImageView imageView) {
        if (isImageVisible) {
            // If image is visible, change its position

            // Use Random number generator to move enemy widget to a random
            // location

            int max = 200;
            int min = -200;

            Random random1 = new java.util.Random();
            Integer randomNumber1 = 0;
            randomNumber1 = random1.nextInt((max - min) + 1) + min;

            Random random2 = new java.util.Random();
            Integer randomNumber2 = 0;
            randomNumber2 = random2.nextInt((max - min) + 1) + min;

            imageView.animate()
                    .translationXBy(randomNumber1)  // Move it a random amount of pixels to the right or left
                    .translationYBy(randomNumber2)  // Move it a random amount of pixels upward or downward
                    .setDuration(500)     // Animation duration
                    .start();
        } else {
            // If image is not visible, reset its position
            imageView.animate()
                    .translationX(0)  // Move it back to its original X position
                    .translationY(0)  // Move it back to its original Y position
                    .setDuration(500) // Animation duration
                    .start();
        }

        // Toggle the visibility state
        isImageVisible = !isImageVisible;
    }

````

## Features
* User authentication
* easy to use 
* Mobile responsiveness
* 

### Future Enhancements
* Add more activites to do
* Improve visuals

## Status
* _Completed_: No further updates planned, but open to feedback and collaboration.

## Challenges
* Handling Firebase. 
* Integration of multiple different imports.

## Learnings
* Improve understanding of FireBase techniques.
* Improved skills in debugging deployment issues.
* Learned to manage collaborative projects efficiently.

## Contributors
List all contributors involved in the project:
* [Daniel Ortega Jr](https://github.com/dancannotcode) - Responsible for getting various bits of data to save to the firebase as well as make the enemies spawn on the clicking tab.
* [Jared Ferriols](https://github.com/JaredFerriols) - Jared was responsible for the clicking and level progression tab. The clicking tab allows the user to interact with the enemies. The level progression tab is required for recording the user's progress.  
* [Nickolys Souza](https://github.com/NsouzaEastbay) - Responsible for the customization and Collection Tab.
* [Thien An Nguyen](https://github.com/nta105) - Responsible for homepage screen, the login screen and initial firebase setup. Posted the JavaDoc for the page.  

## Contact
Feel free to reach out for collaboration, feedback, or questions.  
**Created by:** [Daniel Ortega Jr]  

Connect with me:  
* **Email:** [dancannotcode@gmail.com](mailto:dancannotcode@gmail.com)  
* **GitHub:** [YourGitHubProfile](https://github.com/dancannotcode)  
* **LinkedIn:** [Daniel Ortega Jr](https://www.linkedin.com/in/daniel-ortega-jr-4b79b1336/)
