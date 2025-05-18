[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/DS3PLs8n)
Lily Ashworth – 22012672 – Android Development Coursework
This Mood Tracker application allows users to record their emotional states throughout the
day, add notes to their corresponding moods, and view their mood history for an accurate
reflection of their mental states. It extends the functionality of the starter code by adding data
handling, timestamped entries, and dynamic UI updates. The design follows modern Android
features including Navigation Components and RecyclerViews.
Key features:
1. Log Mood Functionality
   The user can tap the FAB button labelled ‘Log Mood’ to open a screen where they
   can select a mood (Happy, Sad, Angry, Neutral) and optionally add a note.
   On pressing ‘Save’, the mood is timestamped and presented on the main page.
2. Today’s Mood List (First Fragment)
   This displays a chronologically ordered list of moods logged for the current day.
   Each mood is shown with a timestamp, emoji, user-added note, and mood-
   corresponding background colour:
   Happy = Green
   Sad = Blue
   Angry = Red
   Neutral = Yellow
   If no moods have been logged, a message ‘No moods logged today’ is shown
   instead.
3. Past Mood History (Past Moods Fragment)
   This allows users to select a past date with DatePicker.
   The moods for that day are displayed with the same formatting as today’s list on the
   First Fragment.
   If no moods were logged for the selected day, the list is empty.
4. Input Validation
   This prevents saving blank mood entries, handles notes safely and displays user-
   friendly UI feedback for empty states.
5. Clean, responsive UI
   The application uses ConstraintLayout for flexible screen support, and adheres to
   Material Design with colour theming, padding, and button behaviour.

Key Android Concepts Used
 Fragments and navigation components – Used to switch between the mood logging
screen and history views
 Floating Action Button (FAB) – Customised with a ‘plus’ icon to indicate to the user that
they log a mood here.

 RecyclerView – Displays a dynamic list of mood entries
 DatePicker – Allows users to browse mood history by date
User guide
1. Log a mood
   Tap the ‘Log Mood’ FAB on the home screen
   Select your current mood and optionally write a short note
   Tap ‘Save Mood’ to log it
2. View today’s moods
   The main screen shows all the moods logged today, sorted with newest first.
   Each entry shows the time and note (if applicable)
3. View mast moods
   Tap the ‘View mood history’ button on the home screen
   Select a date from the calendar
   View moods logged on that date

This app demonstrates clean architecture, effective use of Android components, and a
practical use-case that is intuitive and useful. The codebase is modular, readable, and
robust against invalid inputs, and allows for a polished user experience.
