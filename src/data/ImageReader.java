package data;

import java.util.ArrayList;
import java.util.List;

public abstract class ImageReader extends MNISTFileReader {
    private static int numberOfImages;
    private static int numberOfRows;
    private static int numberOfColumns;

    public static List<Image> parse(String pathToFile) {
        readFile(pathToFile);

        parseNextInt(); // Magic number
        numberOfImages = parseNextInt();
        numberOfRows = parseNextInt();
        numberOfColumns = parseNextInt();
        return parseImages();
    }

    private static List<Image> parseImages() {
        List<Image> images = new ArrayList<>();
        for (int i = 0; i < numberOfImages; i++) {
            Image image = new Image(numberOfColumns, numberOfRows);
            for (int j = 0; j < image.getSize(); j++) {
                image.addPixel(new Pixel(data.pop()));
            }
            images.add(image);
        }
        return images;
    }
}
