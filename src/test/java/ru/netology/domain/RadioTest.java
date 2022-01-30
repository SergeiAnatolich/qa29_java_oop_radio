package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource({
            "out of range lower,-1,0",
            "lower bound,0,0",
            "general case,4,4",
            "upper bound,9,9",
            "out of range upper,10,0",
    })
    public void testSetCurrentStation(String testName, int station, int expected) {
        Radio rad = new Radio();
        rad.setCurrentStation(station);

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,1",
            "general case,4,5",
            "upper bound,9,0",
    })
    public void testNext(String testName, int station, int expected) {
        Radio rad = new Radio();
        rad.setCurrentStation(station);
        rad.next();

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,9",
            "general case,4,3",
            "upper bound,9,8",
    })
    public void testPrev(String testName, int station, int expected) {
        Radio rad = new Radio();
        rad.setCurrentStation(station);
        rad.prev();

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "out of range lower,-1,0",
            "lower bound,0,0",
            "general case,5,5",
            "upper bound,10,10",
            "out of range upper,11,0",
    })
    public void testSetCurrentVolume(String testName, int volume, int expected) {
        Radio rad = new Radio();
        rad.setCurrentVolume(volume);

        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,1",
            "general case,5,6",
            "upper bound,10,10",
    })
    public void testIncreaseVolume(String testName, int volume, int expected) {
        Radio rad = new Radio();
        rad.setCurrentVolume(volume);
        rad.increaseVolume();

        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,0",
            "general case,5,4",
            "upper bound,10,9",
    })
    public void testDecreaseVolume(String testName, int volume, int expected) {
        Radio rad = new Radio();
        rad.setCurrentVolume(volume);
        rad.decreaseVolume();

        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }
}