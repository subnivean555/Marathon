package pattern.principle.liskovSubstitution;

public class Rectangle {
    private long length;
    private long width;

    public long getLength() {
        return length;
    }

    public long getWidth() {
        return width;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public void setWidth(long width) {
        this.width = width;
    }
}
