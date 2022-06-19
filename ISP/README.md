# Interface Segregation Principle in Java with Example

## Intent/Definition
The ``` Interface Segregation Principle``` states that clients should not be forced to implement interfaces they don't use. ISP splits interfaces that are very large into smaller and more specific ones so that clients will only have to know about the methods that are of interest to them.


The Interface Segregation Principle represents the “I” of the five SOLID Principles of object-oriented programming to write well-designed code that is more readable, maintainable, and easier to upgrade and modify.

## Rules of Thumb?
> Don’t depend on things you don’t need. Interfaces containing methods that are not specific to it are called polluted or fat interfaces. We should avoid them.

> Many client-specific interfaces are better than one general-purpose interface. When we have non-cohesive interfaces, the ISP guides us to create multiple, smaller, cohesive interfaces.

--- 
## Interface Segregation Principle Example
 What the ``` Interface Segregation Principle``` says is that your interface should not be bloated with methods that implementing classes don’t require. For such interfaces, also called “fat interfaces”, implementing classes are unnecessarily forced to provide implementations (dummy/empty) even for those methods that they don’t need. In addition, the implementing classes are subject to change when the interface changes. An addition of a method or change to a method signature requires modifying all the implementation classes even if some of them don’t use the method.

The Interface Segregation Principle advocates segregating a “fat interface” into smaller and highly cohesive interfaces, known as “role interfaces”. Each “role interface” declares one or more methods for a specific behavior. Thus clients, instead of implementing a “fat interface”, can implement only those “role interfaces” whose methods are relevant to them.

Let's understand Interface Segregation Principle with bad and good oops design with examples

--- 
## Bad Code Design
First, let's see "bad" design and implementation.
+ Below is an example which violates the Interface Segregation Principle. Refer below steps to understand the source code and real-world scenarios.
+ Step 1: Interface for a media player to play video and audio
+ Step 2: VLC Media player implements Media player
+ Step 3 : Div Media player implements both VideoMediaPlayer,AudioMediaPlayer
+ Step 4: VLC Media player implements both Video Media Player and Audio Media Player.
+ Step 5: Now there is a need for launching a new Winamp player to play audio, but playing video is not supported at this stage. Here, Winamp player is forced to depend upon interface members they do not use. In this case, playVideo() method is not required

MediaPlayer.java

 ```java
 public interface MediaPlayer {
     public void playAudio();
     public void playVideo();
 }
```

DivMediaPlayer.java

 ```java
public class DivMediaPlayer implements MediaPlayer {
    @Override
    public void playAudio() {
        System.out.println(" Playing audio ..........");
    }

    @Override
    public void playVideo() {
        System.out.println(" Playing video ..........");
    }
}
 ``` 

VlcMediaPlayer.java
 ``` java
public class VlcMediaPlayer implements MediaPlayer {
    @Override
    public void playAudio() {
        System.out.println(" Playing audio ..........");

    }

    @Override
    public void playVideo() {
        System.out.println(" Playing video ..........");

    }
}
 ``` 

WinampMediaPlayer.java
 ``` java
public class WinampMediaPlayer implements MediaPlayer {

    // Play video is not supported in Winamp player
    public void playVideo() {
        throw new VideoUnsupportedException();
    }

    @Override
    public void playAudio() {
        System.out.println("Playing audio ..............");
    }
}
 ``` 

--- 
## Good Code Design
Let's refactor the code to make "good" design using the Interface Segregation Principle.

Class diagram

![interfacesegregation_principle_good](https://user-images.githubusercontent.com/7686353/173933600-c66030b7-9d42-459e-9261-b93d986b6254.png)


Refer below steps to understand the source code and real-world scenarios.
+ Step 1: Interface for playing video
+ Step 2: Interface for playing audio.
+ Step 3 : Div Media player implements both VideoMediaPlayer,AudioMediaPlayer
+ Step 4: VLC Media player implements both VideoMediaPlayer and AudioMediaPlayer.
+ Step 5: Winamp Media player only implements AudioMediaPlayer. Here Winamp Media player only implements Audio Media Player as it supports.

AudioMediaPlayer.java
 ``` java
public interface AudioMediaPlayer {
    public void playAudio();
}
 ``` 

VideoMediaPlayer.java
 ``` java
public interface VideoMediaPlayer {
    // Play video implementation
    public void playVideo();

}
 ``` 

DivMediaPlayer.java
 ``` java

public class DivMediaPlayer implements VideoMediaPlayer, AudioMediaPlayer {

    @Override
    public void playVideo() {
        System.out.println(" Playing video ..........");

    }

    @Override
    public void playAudio() {
        System.out.println(" Playing audio ..........");

    }
}
 ``` 


VlcMediaPlayer.java
 ``` java
public class VlcMediaPlayer implements VideoMediaPlayer, AudioMediaPlayer {

    @Override
    public void playVideo() {
        System.out.println(" Playing video ..........");

    }

    @Override
    public void playAudio() {
        System.out.println(" Playing audio ..........");

    }
}
 ``` 


WinampMediaPlayer.java
 ``` java
public class WinampMediaPlayer implements AudioMediaPlayer {

    @Override
    public void playAudio() {
        System.out.println(" Playing audio........");

    }
}
 ``` 

---- 
## Summary of Interface Segregation Principle

Both the Interface Segregation Principle and Single Responsibility Principle have the same goal: ensuring small, focused, and highly cohesive software components. The difference is that the Single Responsibility Principle is concerned with classes, while the Interface Segregation Principle is concerned with interfaces. Interface Segregation Principle is easy to understand and simple to follow. But, identifying the distinct interfaces can sometimes be a challenge as careful considerations are required to avoid the proliferation of interfaces. Therefore, while writing an interface, consider the possibility of implementation classes having different sets of behaviors, and if so, segregate the interface into multiple interfaces, each having a specific role.

