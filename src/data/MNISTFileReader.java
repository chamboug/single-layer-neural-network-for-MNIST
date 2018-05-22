package data;

import utils.ByteConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;

@SuppressWarnings("WeakerAccess")
public abstract class MNISTFileReader {
    protected static Stack<Byte> data;

    public static void readFile(String pathToFile) {
        data = new Stack<>();
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(pathToFile));
            for (int i = bytes.length-1; i >= 0; i--) {
                data.push(bytes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static int parseNextInt() {
        return ByteConverter.bytesToInt(
                data.pop(),
                data.pop(),
                data.pop(),
                data.pop()
        );
    }
}
