package data;

import java.util.ArrayList;
import java.util.List;

public class Image {
    private List<Integer> pixels;
    private int width;
    private int height;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new ArrayList<>();
    }

    public void addPixel(int pixel) {
        this.pixels.add(pixel);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                int pixel = this.pixels.get(i * this.height + j);
                sb.append(pixel != 0 ? "0" : ".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
