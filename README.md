# HandyCompose [![](https://jitpack.io/v/commandiron/HandyCompose.svg)](https://jitpack.io/#commandiron/HandyCompose)

Android Jetpack Compose implementation of [SpinKit](https://tobiasahlin.com/spinkit/) with additionals.

## How it looks

## Setup
1. Open the file `settings.gradle` (it looks like that)
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // add jitpack here 👇🏽
        maven { url 'https://jitpack.io' }
       ...
    }
} 
...
```
2. Sync the project
3. Add dependency
```groovy
dependencies {
        implementation 'com.github.commandiron:HandyCompose:1.0'
}
```

## Usage
