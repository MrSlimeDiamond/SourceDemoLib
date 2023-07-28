import net.slimediamond.sourcedemo.SourceDemo;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;

public class Main {
    @Test
    public void parseDemo() {
        Path path = new File("/home/findlayr/parseme.dem").toPath();
        SourceDemo demo = SourceDemo.parse(path);

        System.out.println("--- DEMO PATH: " + path + " ---");
        System.out.println("Demo header: " + demo.getHeader());
        System.out.println("Demo protocol: " + demo.getDemoProtocol());
        System.out.println("Network protocol: " + demo.getNetworkProtocol());
        System.out.println("Server name: " + demo.getServerName());
        System.out.println("Client name: " + demo.getClientName());
        System.out.println("Map name: " + demo.getMapName());
        System.out.println("Game directory: " + demo.getGameDirectory());
        System.out.println("Playback time: " + demo.getPlaybackTime());
        System.out.println("Playback ticks: " + demo.getPlaybackTicks());
        System.out.println("Playback frames: " + demo.getPlaybackFrames());
        System.out.println("Sign on length: " + demo.getSignOnLength());
        System.out.println("Tickrate: " + demo.getTickrate());
        System.out.println("-------------------------------------------------------");
    }
}
