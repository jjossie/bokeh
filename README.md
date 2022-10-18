# Overview

Bokeh is (eventually going to be) an app where you can create to-dos and personal goals in order to narrow your focus to what needs to be accomplished in a given day.
The word *bokeh* is a photography term describing the blur effect created in photos by using a camera lens with a shallow depth of field. The unimportant parts of the picture are blurred, beautifully drawing one's focus to the subject. This is what a good productivity app should do - blur out what's unnecessary and narrow your focus to what's most important.

For now, however, it's just a barebones to-do list app.

I've created this app sort of as a way to re-learn Android app development, implementing best practices such as:
* Model-View-ViewModel architecture (MVVM, as opposed to MVC architecture)
* Using LiveData for consistent data display
* Implementing Android Jetpack Navigation
* Properly using RecyclerViews and Adapters

[Watch the Demonstration and Code Walkthrough](https://youtu.be/rHdI0tBf9NY)

# Development Environment

The most important tool, of course, is Android Studio. There's really no reason to try to make Android apps with anything else.

The code was all written in Kotlin, which proved to be a welcome change from my previous Android development experience in Java.
I also made heavy use of Android's built-in libraries, such as the aforementioned ViewModel, LiveData, Navigation, and Adapters, as well as the provided Views like RecyclerView, CardView, ConstraintLayout, and several other built-in components.

# Useful Websites

* [Is it even possible to code without consulting stack overflow every ten minutes?](http://stackoverflow.com)
* [Android Developers](https://developer.android.com/)

# Future Work

There's a lot left to do. In terms of immediate improvements and fixes:
* Make it possible to delete to-do items
* Create new to-dos as a draft first before saving, allowing for better live reload as well as preventing empty to-dos from being created
* Allow list to be sorted / reordered (this will require refactoring the current method of LiveData observance from within the Adapter)
* Animations. I know there's an easy way to make this work better since we are already using Jetpack Navigation - I'm just not sure how.

There's also a lot of features that have yet to be implemented, but are essential for the core concept of the app:
* A goals page which allows for creation of todo-list based goals
* Enable to-do item prioritization and/or multiple to-do lists
* A dashboard that shows the few most important things to focus on for a particular day
* Integration with the Firestore database, and (possibly) Android's Room persistence library
* User authentication


Long-term, however, this may very well end up taking a back burner, and upon revival, might either be an iOS or React Native app instead of Android. Or who knows! Maybe both??
