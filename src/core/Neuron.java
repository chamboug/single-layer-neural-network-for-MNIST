package core;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private List<Connection> inputConnections;
    private List<Connection> outputConnections;

    public Neuron() {
        this.inputConnections = new ArrayList<>();
        this.outputConnections = new ArrayList<>();
    }

    public void addInputConnection(Connection connection) {
        this.inputConnections.add(connection);
    }

    public List<Connection> getInputConnections() {
        return this.inputConnections;
    }

    public void addOutputConnection(Connection connection, Neuron neuron) {
        this.outputConnections.add(connection);
        neuron.addInputConnection(connection);
    }

    public void addOutputConnection(Connection connection) {
        this.outputConnections.add(connection);
    }

    public List<Connection> getOutputConnections() {
        return outputConnections;
    }

    public void computeOutput() {
        double outputValue = this.getOutputValue();
        for (Connection connection : this.outputConnections) {
            connection.setInput(outputValue);
        }
    }

    public double getOutputValue() {
        double value = 0;
        for (Connection connection : this.inputConnections) {
            value += connection.getInput() * connection.getWeight();
        }
        return value;
    }
}
