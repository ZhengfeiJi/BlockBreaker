import java.io.*;
import sun.audio.*;

/**
 * Can load a *.wav or *.au audio file from a given path and play it.
 * 
 */
public class AudioFile {
    
    String path;
    
    /**
     * Constructs an object that save the path in the supplied parameter in a 'path' field
     *
     * @param path Takes a path of an audio file
     */ 
    
    public AudioFile(String path) {
        this.path = path;       
    }
    /**
     * Loads and play an audio file
     *
     * @param path Takes a path of an audio file
     */   
   
    public void playAudio(String path) {    

            try {
                InputStream in = new FileInputStream(path);
                // create an audiostream from the inputstream
                AudioStream audioStream = new AudioStream(in);
                AudioPlayer.player.start(audioStream);
                // play the audio clip with the audioplayer class               
            } catch(Exception e) {
                // code to handle the exception
            }                         
    }
    
    
    /**
     * Loads and play an audio file
     *
     * @erturn path Returns a path of an audio file 
     */   
    public String getPath(){
        return path;
    }
    
    
    
    
    
    
    
    
}