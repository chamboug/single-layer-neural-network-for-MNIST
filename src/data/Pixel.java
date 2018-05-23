package data;

public class Pixel {
    private int value;

    public Pixel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isBlank() {
        return value == 0;
    }
}
