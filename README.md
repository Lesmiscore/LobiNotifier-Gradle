# LobiNotifier-Gradle
Lobi notification tool for Gradle build system.

# Usages
First, add these lines to your **root** level `build.gradle`.

```groovy
buildscript{
    repositories {
        ...
        maven{url "https://github.com/nao20010128nao/MavenRepo/raw/master/releases/"}//Add this line
        ...
    }
    dependencies {
        ....
        classpath "com.nao20010128nao:lobinotifier-gradle:1.0"//Add this line
        ....
    }
}
```
Second, add this line to your **module** level `build.gradle`.

```groovy
apply plugin: ...
apply plugin: 'lobinotifier'//Add this line

...
```

----
WIP
