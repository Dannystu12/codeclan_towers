package hotel.enums;

public enum BedroomType {
    SINGLE(1, 75),
    DOUBLE(2, 125),
    PRESIDENTIAL(4, 150);

    private final int CAPACITY;
    private final double RATE;

    BedroomType(int capacity, double rate){
        CAPACITY = capacity;
        RATE = rate;
    }

    public int getCapacity(){
        return CAPACITY;
    }

    public double getRate(){
        return RATE;
    }
}
