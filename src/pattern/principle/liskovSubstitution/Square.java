package pattern.principle.liskovSubstitution;

public class Square extends Rectangle{

    private long sideLength;

    @Override
    public void setLength(long length) {
        setSideLength(length);
    }

    @Override
    public void setWidth(long width) {
        setSideLength(width);
    }

    public void setSideLength(long sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public long getLength() {
        return sideLength;
    }

    @Override
    public long getWidth() {
        return sideLength;
    }
}
