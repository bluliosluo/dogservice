package org.chloe.demo.dogtoy;

import org.springframework.stereotype.Component;


public class DogMondayToy implements DogToy{
    private long x;
    private long y;

    public DogMondayToy(long x, long y) {
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
