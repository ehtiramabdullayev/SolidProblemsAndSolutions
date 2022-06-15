# Intent/Definition
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

 ``` 
 public interface MediaPlayer {
     public void playAudio();
     public void playVideo();
 }
```

DivMediaPlayer.java

 ``` 
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
 ``` 
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
 ``` 
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
