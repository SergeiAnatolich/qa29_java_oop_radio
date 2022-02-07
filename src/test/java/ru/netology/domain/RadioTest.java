package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();
    Radio radioChangeStation = new Radio(30);

    @ParameterizedTest
    @CsvSource({
            "out of range lower,-1,0",
            "lower bound,0,0",
            "general case,4,4",
            "upper bound,9,9",
            "out of range upper,10,0",
    })
    public void testSetCurrentStation(String testName, int station, int expected) {
        radio.setCurrentStation(station);

        int actual = radio.getCurrentStation();

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
    public void testSetCurrentStationRadioChangeStation(String testName, int station, int expected) {
        radioChangeStation.setCurrentStation(station);

        int actual = radioChangeStation.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,1",
            "general case,4,5",
            "upper bound,9,0",
    })
    public void testNext(String testName, int station, int expected) {
        radio.setCurrentStation(station);
        radio.next();

        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,1",
            "general case,15,16",
            "upper bound,29,0",
    })
    public void testNextRadioChangeStation(String testName, int station, int expected) {
        radioChangeStation.setCurrentStation(station);
        radioChangeStation.next();

        int actual = radioChangeStation.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,9",
            "general case,4,3",
            "upper bound,9,8",
    })
    public void testPrev(String testName, int station, int expected) {
        radio.setCurrentStation(station);
        radio.prev();

        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,29",
            "general case,15,14",
            "upper bound,29,28",
    })
    public void testPrevRadioChangeStation(String testName, int station, int expected) {
        radioChangeStation.setCurrentStation(station);
        radioChangeStation.prev();

        int actual = radioChangeStation.getCurrentStation();

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
        radio.setCurrentVolume(volume);

        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,1",
            "general case,50,51",
            "upper bound,100,100",
    })
    public void testIncreaseVolume(String testName, int volume, int expected) {
        radio.setCurrentVolume(volume);
        radio.increaseVolume();

        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "lower bound,0,0",
            "general case,50,49",
            "upper bound,100,99",
    })
    public void testDecreaseVolume(String testName, int volume, int expected) {
        radio.setCurrentVolume(volume);
        radio.decreaseVolume();

        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetRadioChangeAll() {
        Radio radioChangeAll = new Radio(30, 0, 20);

        int actualAS = radioChangeAll.getAmountStation();
        assertEquals(30, actualAS);

        int actualCS = radioChangeAll.getCurrentStation();
        assertEquals(0, actualCS);

        int actualCV = radioChangeAll.getCurrentVolume();
        assertEquals(20, actualCV);
    }
}