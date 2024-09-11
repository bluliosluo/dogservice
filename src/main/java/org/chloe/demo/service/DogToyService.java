package org.chloe.demo.service;

import org.chloe.demo.dogtoy.DogToy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DogToyService {

    private final DogToy dogMondayToy;
    private final DogToy dogSundayToy;

    public DogToyService(
        @Qualifier("dogSundayToy") DogToy dogSundayToy,
        @Qualifier("dogMondayToy") DogToy dogMondayToy) { // 和configuration保持一致
        this.dogSundayToy = dogSundayToy;
        this.dogMondayToy = dogMondayToy;

    }

    public void moveDogSundayToy(long dx, long dy) {
        dogSundayToy.move(dx, dy);
    }

    public void moveDogMondayToy(long dx, long dy) {
        dogMondayToy.move(dx, dy);
    }
}
