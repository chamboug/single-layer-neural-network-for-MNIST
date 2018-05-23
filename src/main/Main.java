package main;

import core.NeuralNetwork;
import data.Image;
import data.ImageReader;
import data.LabelReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Parsing training data...");
        List<Image> trainImages = ImageReader.parse("data/train-images.idx3-ubyte");
        LabelReader.parse("data/train-labels.idx1-ubyte", trainImages);

        System.out.println("Creating and training neural network...");
        NeuralNetwork network = new NeuralNetwork(784, 10);
        network.train(trainImages);
        System.out.println("Neural network ready !");

        System.out.println("Parsing test data...");
        List<Image> testImages = ImageReader.parse("data/t10k-images.idx3-ubyte");
        LabelReader.parse("data/t10k-labels.idx1-ubyte", testImages);

        System.out.println("Testing...");
        network.test(testImages);
        System.out.println("SUCCESS RATE : " + network.getSuccessRate());
    }
}
