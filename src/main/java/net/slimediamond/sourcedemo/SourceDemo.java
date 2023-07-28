package net.slimediamond.sourcedemo;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;

import static net.slimediamond.sourcedemo.SBCUtils.*;

public class SourceDemo {
    private String header;
    private int demoProtocol;
    private int networkProtocol;
    private String serverName;
    private String clientName;
    private String mapName;
    private String gameDirectory;
    private float playbackTime;
    private int playbackTicks;
    private int playbackFrames;
    private int signOnLength;
    private int tickrate;

    private SourceDemo(String header, int demoProtocol, int networkProtocol, String serverName, String clientName, String mapName, String gameDirectory, float playbackTime, int playbackTicks, int playbackFrames, int signOnLength) {
        this.header = header;
        this.demoProtocol = demoProtocol;
        this.networkProtocol = networkProtocol;
        this.serverName = serverName;
        this.clientName = clientName;
        this.mapName = mapName;
        this.gameDirectory = gameDirectory;
        this.playbackTime = playbackTime;
        this.playbackTicks = playbackTicks;
        this.playbackFrames = playbackFrames;
        this.signOnLength = signOnLength;
        this.tickrate = (int) Math.floor(playbackTicks / playbackTime);
    }

    /**
     * Parse a source demo using a file
     * @param path The file
     */
    public static SourceDemo parse(Path path) {
        try (SeekableByteChannel sbc = Files.newByteChannel(path)) {
            String header = readString(sbc, 8).trim();
            int demoProtocol = readInt(sbc);
            int networkProtocol = readInt(sbc);
            String serverName = readString(sbc, 260).trim();
            String clientName = readString(sbc, 260).trim();
            String mapName = readString(sbc, 260).trim();
            String gameDirectory = readString(sbc, 260).trim();
            float playbackTime = readFloat(sbc);
            int playbackTicks = readInt(sbc);
            int playbackFrames = readInt(sbc);
            int signOnLength = readInt(sbc);

            return new SourceDemo(header, demoProtocol, networkProtocol, serverName, clientName, mapName, gameDirectory, playbackTime, playbackTicks, playbackFrames, signOnLength);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getHeader() {
        return header;
    }

    public int getDemoProtocol() {
        return demoProtocol;
    }

    public int getNetworkProtocol() {
        return networkProtocol;
    }

    public String getServerName() {
        return serverName;
    }

    public String getClientName() {
        return clientName;
    }

    public String getMapName() {
        return mapName;
    }

    public String getGameDirectory() {
        return gameDirectory;
    }

    public float getPlaybackTime() {
        return playbackTime;
    }

    public int getPlaybackTicks() {
        return playbackTicks;
    }

    public int getPlaybackFrames() {
        return playbackFrames;
    }

    public int getSignOnLength() {
        return signOnLength;
    }

    public int getTickrate() {
        return tickrate;
    }
}
