package main;

import data.Image;
import data.ImageReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Image> l = ImageReader.parse("data/train-images.idx3-ubyte");
        for (int i = 0; i < 20; i++) {
            System.out.println(l.get(i));
        }
    }
}
