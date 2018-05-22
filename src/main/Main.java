package main;

import data.Image;
import data.ImageReader;
import data.LabelReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Image> images = ImageReader.parse("data/train-images.idx3-ubyte");
        LabelReader.parse("data/train-labels.idx1-ubyte", images);
        for (int i = 0; i < 20; i++) {
            System.out.println(images.get(i));
        }
    }
}
