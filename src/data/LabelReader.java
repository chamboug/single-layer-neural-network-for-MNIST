package data;

import java.util.List;

public abstract class LabelReader extends MNISTFileReader {

    public static void parse(String pathToFile, List<Image> images) {
        readFile(pathToFile);

        parseNextInt(); // Magic number
        parseNextInt(); // Number of labels
        linkLabelsToImages(images);
    }

    private static void linkLabelsToImages(List<Image> images) {
        for (Image image : images) {
            image.setValue(data.pop());
        }
    }
}
