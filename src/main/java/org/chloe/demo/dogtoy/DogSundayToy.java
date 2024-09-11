package org.chloe.demo.dogtoy;

public class DogSundayToy implements DogToy{
    private long x;
    private long y;

    public DogSundayToy(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(long dx, long dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void shutdown() {
        // System.out.println("DogSundayToy is shutting down");
    }

}
