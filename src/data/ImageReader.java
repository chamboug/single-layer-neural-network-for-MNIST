package data;

import utils.ByteConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class ImageReader {
    private static Stack<Byte> data;
    private static int numberOfImages;
    private static int numberOfRows;
    private static int numberOfColumns;

    public static List<Image> parse(String pathToFile) {
        data = new Stack<>();
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(pathToFile));
            for (int i = bytes.length-1; i >= 0; i--) {
                data.push(bytes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        parseNextInt(); // Magic number
        numberOfImages = parseNextInt();
        numberOfRows = parseNextInt();
        numberOfColumns = parseNextInt();
        return parseImages();
    }

    private static int parseNextInt() {
        return ByteConverter.bytesToInt(
                data.pop(),
                data.pop(),
                data.pop(),
                data.pop()
        );
    }

    private static List<Image> parseImages() {
        List<Image> images = new ArrayList<>();
        for (int i = 0; i < numberOfImages; i++) {
            Image image = new Image(numberOfColumns, numberOfRows);
            for (int j = 0; j < numberOfRows*numberOfColumns; j++) {
                image.addPixel(data.pop());
            }
            images.add(image);
        }
        return images;
    }
}
