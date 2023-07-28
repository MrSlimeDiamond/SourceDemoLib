package net.slimediamond.sourcedemo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SeekableByteChannel;

public class SBCUtils {
    public static int readInt(SeekableByteChannel sbc) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        sbc.read(buffer);
        return buffer.getInt(0);
    }

    public static String readString(SeekableByteChannel sbc, int size) throws IOException {
        byte[] rawBuffer = new byte[size];
        ByteBuffer buffer = ByteBuffer.wrap(rawBuffer);
        sbc.read(buffer);
        return new String(rawBuffer);
    }

    public static float readFloat(SeekableByteChannel sbc) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        sbc.read(buffer);
        return buffer.getFloat(0);
    }

}
