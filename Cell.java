public class Cell {
    private int value;
    private boolean empty;
    private boolean isMarker;

    public Cell() {
        value = (int)(Math.random() * 10) -5;
        empty = false;
        isMarker = false;
    }

    public int getValue() {
        return value;
    }

    public boolean isEmpty() {
        return empty && isMarker;
    }

    public void setMarker() {
        isMarker = true;
    }

    public void removeMarker() {
        isMarker = false;
    }

    public boolean isMarker() {
        return isMarker;
    }

    public void setEmpty() {
        empty = true;
    }

    public String toString() {
        String data = "Value: " + value + " Empty: " + empty;
        return data;
    }
}
