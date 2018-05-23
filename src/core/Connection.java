package core;

import utils.RandomGenerator;

public class Connection {
    private double input;
    private double weight;

    public Connection() {
        this.input = 0;
        this.weight = RandomGenerator.getInstance().nextDouble();
    }

    public void setInput(double input) {
        this.input = input;
    }

    public double getInput() {
        return input;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void increaseWeight(double value) {
        this.weight += value;
    }
}
