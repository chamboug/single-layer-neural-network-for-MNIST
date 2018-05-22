package data;

import java.util.ArrayList;
import java.util.List;

public class Image {
    private List<Integer> pixels;
    private int width;
    private int height;
    private int value;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.value = 0;
        this.pixels = new ArrayList<>();
    }

    public void addPixel(int pixel) {
        this.pixels.add(pixel);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Value : ").append(this.value).append("\n");
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
