## Kotlin/JS React, Redux with thunk and Material UI example App

There is a lack of information about the using Kotlin for Web apps. 
After spending a lot of hours setting up React in my own 
[Kotlin multiplatform](https://github.com/AKJAW/fuller-stack-kotlin-multiplatform) 
project, I thought I would share the basic setup that I use.

The app uses:

- Redux for state management and redux-thunk for asynchronous actions
- redux-devtools for debugging the Redux store
- React classes and functional components with state hooks
- Material UI provided by [muirwik](https://github.com/cfnz/muirwik)
- A custom webpack configuration (**webpack.config.js**)

The architecture I use is as follows:

- Container components are the entry points for Redux state and actions
- Functional components are used for styles and also for local state (state hooks)
- Redux reducers and its state/actions are placed in one object called slice 
(something akin to [Redux Toolkit](https://redux-toolkit.js.org/))
- All thunks are defined in a separate class/object (if they use coroutines, 
the scope can be passed in through the constructor)

To run the app use the standard gradle command **browserDevelopmentRun**. The app 
will run on port 8080, but it will not auto open because of the custom webpack 
config.
```shell script
./gradlew browserDevelopmentRun
```

The application in this repository is a collection of information I found about
Kotlin/JS in one place. I hope it will help some people with setting up their
own React apps in Kotlin.

Here are the resources I used for learning and creating this project:

- [Building Web Applications with React and Kotlin/JS](https://play.kotlinlang.org/hands-on/Building%20Web%20Applications%20with%20React%20and%20Kotlin%20JS/01_Introduction)
- [React in Kotlin/JS, What I learned by Jolanrensen](https://discuss.kotlinlang.org/t/react-in-kotlin-js-what-i-learned-long-but-useful-read/16168)
- [Kotlin React Redux PoC (A great resource for learning Redux in Kotlin)](https://github.com/lawik123/kotlin-poc-frontend-react-redux)
- [KotlinExamples (I used it to implement Redux thunk)](https://github.com/AltmanEA/KotlinExamples)

The one thing that I couldn't get working is the ErrorBoundary caused by the lack
of **getDerivedStateFromError**. If someone knows how to implements this in
Kotlin, please feel free to reach out and improve this example. All other 
feedback is also appreciated.

A more in-depth description and explanation of the project can be found on [My Blog](https://akjaw.com/blog/kotlinjs_react_redux_with_thunk_and_material_ui)
