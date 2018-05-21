package utils;

public class ByteConverter {
    public static int bytesToInt(byte b1, byte b2, byte b3, byte b4) {
        return (b1<<24)&0xff000000|
                (b2<<16)&0x00ff0000|
                (b3<< 8)&0x0000ff00|
                (b4)&0x000000ff;
    }
}
