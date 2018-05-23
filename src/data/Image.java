package data;

import java.util.ArrayList;
import java.util.List;

public class Image {
    private List<Pixel> pixels;
    private int width;
    private int height;
    private int value;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.value = 0;
        this.pixels = new ArrayList<>();
    }

    public void addPixel(Pixel pixel) {
        this.pixels.add(pixel);
    }

    public List<Pixel> getPixels() {
        return this.pixels;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public double getSize() {
        return this.width * this.height;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("Value : ").append(this.value).append("\n");
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Pixel pixel = this.pixels.get(i * this.height + j);
                sb.append(pixel.isBlank() ? "8" : " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
