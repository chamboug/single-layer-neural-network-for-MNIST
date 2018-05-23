package core;

import data.Image;
import data.Pixel;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {

    private final static double LEARNING_RATE = 0.15;

    private List<Neuron> inputLayer;
    private List<Neuron> outputLayer;
    private double successRate;

    public NeuralNetwork(int inputLayerSize, int outputLayerSize) {
        this.successRate = 0;
        this.outputLayer = new ArrayList<>();
        for (int i = 0; i < outputLayerSize; i++) {
            Neuron neuron = new Neuron();
            neuron.addOutputConnection(new Connection());
            this.outputLayer.add(neuron);
        }
        this.inputLayer = new ArrayList<>();
        for (int i = 0; i < inputLayerSize; i++) {
            Neuron neuron = new Neuron();
            neuron.addInputConnection(new Connection());
            for (Neuron n : this.outputLayer) {
                neuron.addOutputConnection(new Connection(), n);
            }
            this.inputLayer.add(neuron);
        }
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void train(List<Image> images) {
        computeImages(images, true);
    }

    public void test(List<Image> images) {
        this.successRate = 0;
        computeImages(images, false);
        this.successRate = (this.successRate / images.size()) * 100;
    }

    private void computeImages(List<Image> images, boolean isTraining) {
        for (Image image : images) {
            computeImage(image, isTraining);
        }
    }

    private void computeImage(Image image, boolean isTraining) {
        setInputsAccordingToImage(image);
        computeLayersOutput();
        double bestValue = 0;
        int bestNumber = -1;
        for (int neuronIndex = 0; neuronIndex < this.outputLayer.size(); neuronIndex++) {
            Neuron neuron = this.outputLayer.get(neuronIndex);
            double outputConnectionValue = neuron.getOutputValue() / image.getSize();

            if (outputConnectionValue > bestValue) {
                bestValue = outputConnectionValue;
                bestNumber = neuronIndex;
            }

            if (isTraining) {
                this.improveConnectionWeights(image.getValue(), neuronIndex, neuron, outputConnectionValue);
            }
        }

        if (!isTraining && bestNumber == image.getValue()) {
            this.successRate++;
        }
    }

    private void computeLayersOutput() {
        for (Neuron neuron : this.inputLayer) {
            neuron.computeOutput();
        }
        for (Neuron neuron : this.outputLayer) {
            neuron.computeOutput();
        }
    }

    private void improveConnectionWeights(int imageValue, int neuronIndex, Neuron neuron, double outputConnectionValue) {
        double isExpected = imageValue == neuronIndex ? 1 : 0;
        double error = isExpected - outputConnectionValue;
        for (Connection connection : neuron.getInputConnections()) {
            connection.increaseWeight(LEARNING_RATE * connection.getInput() * error);
        }
    }

    private void setInputsAccordingToImage(Image image) {
        List<Pixel> pixels = image.getPixels();
        for (int pixelIndex = 0; pixelIndex < pixels.size(); pixelIndex++) {
            Pixel pixel = pixels.get(pixelIndex);
            List<Connection> connections = this.inputLayer.get(pixelIndex).getInputConnections();
            // Each neuron of the input layer has one and only one input connection
            connections.get(0).setInput(pixel.isBlank() ? 0 : 1);
        }
    }
}
