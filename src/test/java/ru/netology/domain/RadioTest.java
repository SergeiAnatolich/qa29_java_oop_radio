package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio rad = new Radio();

    @ParameterizedTest
    @CsvSource({
            "out of range lower,-1,0",
            "lower bound,0,0",
            "general case,4,4",
            "upper bound,9,9",
            "out of range upper,10,0",
    })
    public void testSetCurrentStation(String testName, int station, int expected) {
        rad.setCurrentStation(station);

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "out of range lower,-1,0",
            "lower bound,0,0",
            "general case,15,15",
            "upper bound,29,29",
            "out of range upper,30,0",
    })
    public void testSetCurrentStationRad1(String testName, int station, int expected) {
        Radio rad1 = new Radio(30);
        rad1.setCurrentStation(station);

        int actual = rad1.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,1",
            "general case,4,5",
            "upper bound,9,0",
    })
    public void testNext(String testName, int station, int expected) {
        rad.setCurrentStation(station);
        rad.next();

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,1",
            "general case,15,16",
            "upper bound,29,0",
    })
    public void testNextRad1(String testName, int station, int expected) {
        Radio rad1 = new Radio(30);
        rad1.setCurrentStation(station);
        rad1.next();

        int actual = rad1.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,9",
            "general case,4,3",
            "upper bound,9,8",
    })
    public void testPrev(String testName, int station, int expected) {
        rad.setCurrentStation(station);
        rad.prev();

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,29",
            "general case,15,14",
            "upper bound,29,28",
    })
    public void testPrevRad1(String testName, int station, int expected) {
        Radio rad1 = new Radio(30);
        rad1.setCurrentStation(station);
        rad1.prev();

        int actual = rad1.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "out of range lower,-1,15",
            "lower bound,0,0",
            "general case,50,50",
            "upper bound,100,100",
            "out of range upper,101,15",
    })
    public void testSetCurrentVolume(String testName, int volume, int expected) {
        rad.setCurrentVolume(volume);

        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,1",
            "general case,50,51",
            "upper bound,100,100",
    })
    public void testIncreaseVolume(String testName, int volume, int expected) {
        rad.setCurrentVolume(volume);
        rad.increaseVolume();

        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,0",
            "general case,50,49",
            "upper bound,100,99",
    })
    public void testDecreaseVolume(String testName, int volume, int expected) {
        rad.setCurrentVolume(volume);
        rad.decreaseVolume();

        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }
}