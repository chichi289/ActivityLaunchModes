## Activity Launch mode Demo Application

###### This demo application is designed to help you understand how the launch mode of an Activity affects its behavior when it's started from another Activity.

 [Reference](https://developer.android.com/guide/topics/manifest/activity-element#lmode)

 * Standard
 * SingleTop
 * SingleTask
 * SingleInstance
 * singleInstancePerTask

Activity launch modes in Android define how a new instance of an activity is created and related to the existing activities on the back stack. Each launch mode serves different purposes and can be used in specific scenarios. Let's explore each launch mode and their real use cases by considering an example of a messaging app:

Example App: Messaging App

Imagine you're building a messaging app that has the following main activities:

    MainActivity: This is the home screen of the app, displaying a list of conversations with 
    different contacts.

    ChatActivity: This activity is responsible for displaying the chat conversation with a 
    particular contact.

    ComposeActivity: This activity is used to compose a new message to send to a contact.

Now, let's see how each launch mode can be applied to these activities to achieve different behaviors:

##### standard:

    This is the default launch mode for activities. A new instance of the activity is created every
    time it is launched, regardless of whether an existing instance already exists on the back stack.

    Use case: The standard launch mode is typically used for most activities, including the 
    MainActivity, as it allows multiple instances of the activity to exist, and each instance 
    maintains its own state. For instance, the user might want to open multiple conversations 
    simultaneously.

##### singleTop:

    If an instance of the activity already exists at the top of the back stack, a new instance will
    not be created. Instead, the existing instance will be reused, and the onNewIntent() method will
    be called to handle the new intent.

    Use case: The ChatActivity can use the singleTop launch mode. When the user receives a new 
    message from a contact they are currently chatting with, tapping on the notification should bring
    the existing ChatActivity to the front without creating a new instance. This avoids unnecessary 
    stacking of the same chat activity.

##### singleTask:

    If an instance of the activity already exists in the back stack, the system will bring it to the
    front and clear all the activities on top of it.

    Use case: The ComposeActivity can use the singleTask launch mode. When the user taps on the 
    "Compose" button from the MainActivity or ChatActivity, you want to bring the existing 
    ComposeActivity to the front. If there are any other activities on top of the ComposeActivity, 
    they will be cleared, ensuring that the user starts with a fresh compose screen.

##### singleInstance:

    A new task will always be created and a new instance of the activity will be placed at the root of
    the new task. No other activities will be included in this task.

    Use case: You might use the singleInstance launch mode for a special activity, like a full-screen
    photo viewer. When the user opens the photo viewer, it should not be part of the normal app flow 
    and should run independently in its own task. This ensures that the photo viewer remains separate 
    from the rest of the app's activities.

##### singleInstancePerTask:

    This is a custom launch mode that indicates a new instance will be created only if there is no 
    existing instance in the current task. If there is an existing instance, that instance will be
    brought to the front.

    Use case: This launch mode can be used if you have a unique and critical task that should be 
    accessed from multiple entry points, but you want to ensure that there is only one instance of
    it per task. For instance, if you have a "PaymentActivity," you want to make sure there is only
    one active instance at any given time.

| Screenshots                                                                      |                                                                                    |                                                                                    |
|----------------------------------------------------------------------------------|------------------------------------------------------------------------------------|------------------------------------------------------------------------------------|
| <img src="/screenshots/1.JPEG" align="left" width="200" hspace="10" vspace="10"> | <img src="/screenshots/2.JPEG" align="center" width="200" hspace="10" vspace="10"> | <img src="/screenshots/3.JPEG" align="center" width="200" hspace="10" vspace="10"> |

### Note

> Modify the launch mode of activities in the manifest file (AndroidManifest.xml) to test different scenarios.

### Download & Credit

> Build for testing
<a href="/apk/launch-mode-app-debug.apk" title="Download" download>Download</a>

> Inspired from
<a href="https://github.com/AnilDeshpande/ActivityLauchModesDemo" title="AnilDeshpande">AnilDeshpande</a>