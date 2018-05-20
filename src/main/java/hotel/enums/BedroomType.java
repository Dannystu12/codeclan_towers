package hotel.enums;

public enum BedroomType {
    SINGLE(1),
    DOUBLE(2),
    PRESIDENTIAL(4);

    private final int CAPACITY;

    BedroomType(int capacity){
        CAPACITY = capacity;
    }

    public int getCapacity(){
        return CAPACITY;
    }
}
