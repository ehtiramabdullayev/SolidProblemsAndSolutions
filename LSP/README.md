# Liskov Substitution Principle in Java with Example

## Intent/Definition
Derived types must be completely substitutable for their base types.

The Liskov Substitution Principle represents the “L” of the five ```SOLID Principles``` of object-oriented programming to write well-designed code that is more readable, maintainable, and easier to upgrade and modify.

### Rules of Thumb?

+ This principle applies to inheritance hierarchies and is just an extension of the Open Close Principle.
+ It means that we must make sure that new derived classes are extending the base classes without changing their original behavior. Basically, derived classes should never do less than their base class.
+ If a subtype of the supertype does something that the client of the supertype does not expect, then this is in violation of LSP. Imagine a derived class throwing an exception that the superclass does not throw, or if a derived class has some unexpected side effects. One has to consider that how the client programs are using the class hierarchy. Sometimes code refactoring is required to fix identified LSP violations.


### Liskov's Substitution Principle Example
First, let's see "bad" design and implementation.

#### Bad Code Design
LSP is violated here! Why? Logically WinampMediaPlayer only supports playing audio. So what's wrong with the overriding playVideo method of a super class?
MediaPlayer.java
```java
public class MediaPlayer {

    // Play audio implementation
    public void playAudio() {
        System.out.println("Playing audio...");
    }

    // Play video implementation
    public void playVideo() {
        System.out.println("Playing video...");
    }
}
```

VlcMediaPlayer.java
```java
public class VlcMediaPlayer extends MediaPlayer {

}
```

WinampMediaPlayer.java
```java
public class WinampMediaPlayer extends MediaPlayer {

    // Play video is not supported in Winamp player
    public void playVideo() {
        throw new VideoUnsupportedException();
    }
}
```

VideoUnsupportedException.java
```java
public class VideoUnsupportedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

}
```

ClientTestProgram.java
```java
public class ClientTestProgram {

    public static void main(String[] args) {

        // Created list of players
        List < MediaPlayer > allPlayers = new ArrayList < MediaPlayer > ();
        allPlayers.add(new VlcMediaPlayer());
        allPlayers.add(new DivMediaPlayer());

        // Play video in all players
        playVideoInAllMediaPlayers(allPlayers);

        // Well - all works as of now...... :-)
        System.out.println("---------------------------");

        // Now adding new Winamp player
        allPlayers.add(new WinampMediaPlayer());

        // Again play video in all players & Oops it broke the program... :-(
        // Why we got unexpected behavior in client? --- Because LSP is violated in WinampMediaPlayer.java, 
        // as it changed the original behavior of super class MediaPlayer.java
        playVideoInAllMediaPlayers(allPlayers);
    }

    /**
     * This method is playing video in all players
     * 
     * @param allPlayers
     */
    public static void playVideoInAllMediaPlayers(List < MediaPlayer > allPlayers) {

        for (MediaPlayer player: allPlayers) {
            player.playVideo();
        }
    }
}
```
+ Refer MediaPlayer.java superclass and its subclasses DivMediaPlayer.java, VlcMediaPlayer.java- Refer ClientTestProgram.java code, before adding "WinampMediaPlayer.java"
+ Now WinampMediaPlayer.java is added, in which LSP is violated
+ Oops, it broken "ClientTestProgram.java"

## Good Code Design
Let's refactor the code to make "good" design using LSP?

+ Refer "MediaPlayer.java" super class and its sub class "AudioMediaPlayer.java" having play audio ability
+ Refer "VideoMediaPlayer.java" extends "MediaPlayer.java" and adds play video ability
+ Refer "DivMediaPlayer.java", "VlcMediaPlayer.java". Both extends "VideoMediaPlayer.java" for play audio and video ability.
+ Refer "WinampMediaPlayer.java" which extends "AudioMediaPlayer.java" for play audio ability.
+ So client program can substitute "VideoMediaPlayer.java" super type with "DivMediaPlayer.java" or "VlcMediaPlayer.java", but not with "WinampMediaPlayer.java"

Class diagram

![liskovssubstitution_principle_bad](https://user-images.githubusercontent.com/7686353/173936836-7c0e16e8-9748-4a50-aee6-34e98c13c1b3.png)



MediaPlayer.java
```java
public class MediaPlayer {

    // Play audio implementation
    public void playAudio() {
        System.out.println("Playing audio...");
    }
}
```
DivMediaPlayer.java
```java
public class DivMediaPlayer extends VideoMediaPlayer {
// DivMediaPlayer code goes here
}
```
VlcMediaPlayer.java
```java
public class VlcMediaPlayer extends VideoMediaPlayer {
// VlcMediaPlayer code goes here
}
```
VideoMediaPlayer.java
```java
public class VideoMediaPlayer extends MediaPlayer {

    // Play video implementation
    public void playVideo() {
        System.out.println("Playing video...");
    }
}
```
WinampMediaPlayer.java
```java
public class WinampMediaPlayer extends AudioMediaPlayer {
// WinampMediaPlayer code goes here
}
```
VideoUnsupportedException.java
```java
public class VideoUnsupportedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

}
```
ClientTestProgram.java
```java
public class ClientTestProgram {

    public static void main(String[] args) {

        // Created list of video players
        List < VideoMediaPlayer > allPlayers = new ArrayList < VideoMediaPlayer > ();
        allPlayers.add(new VlcMediaPlayer());
        allPlayers.add(new DivMediaPlayer());

        // Play video in all players
        playVideoInAllMediaPlayers(allPlayers);

        // Well - all works as of now...... :-)
        System.out.println("---------------------------");

        // Now adding new Winamp player. If you uncomment below line,
        // it would give compile time error as can't add audio player in list of video players.
        // allPlayers.add(new WinampMediaPlayer()); 
    }

    /**
     * This method is playing video in all players
     * 
     * @param allPlayers
     */
    public static void playVideoInAllMediaPlayers(List < VideoMediaPlayer > allPlayers) {

        for (VideoMediaPlayer player: allPlayers) {
            player.playVideo();
        }
    }
}
```
