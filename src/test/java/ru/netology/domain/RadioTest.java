package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    public void testSetCurrentStation() {
        Radio rad = new Radio();
        rad.setCurrentStation(6);

        int expected = 6;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetCurrentStationMoreLimit() {
        Radio rad = new Radio();
        rad.setCurrentStation(10);

        int expected = 0;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetCurrentStationLessLimit() {
        Radio rad = new Radio();
        rad.setCurrentStation(-1);

        int expected = 0;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    public void testNext() {
        Radio rad = new Radio();
        rad.Next();

        int expected = 1;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    public void testNextRound() {
        Radio rad = new Radio();
        rad.setCurrentStation(9);
        rad.Next();

        int expected = 0;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    public void testPrev() {
        Radio rad = new Radio();
        rad.setCurrentStation(7);
        rad.Prev();

        int expected = 6;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    public void testPrevRound() {
        Radio rad = new Radio();
        rad.Prev();

        int expected = 9;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    public void testIncreaseVolume() {
        Radio rad = new Radio();
        rad.increaseVolume();

        int expected = 1;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    public void testIncreaseVolumeMax() {
        Radio rad = new Radio();
        rad.setCurrentVolume(10);
        rad.increaseVolume();

        int expected = 10;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    public void testDecreaseVolumeMin() {
        Radio rad = new Radio();
        rad.decreaseVolume();

        int expected = 0;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    public void testDecreaseVolume() {
        Radio rad = new Radio();
        rad.setCurrentVolume(10);
        rad.decreaseVolume();

        int expected = 9;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetCurrentVolumeMoreLimit() {
        Radio rad = new Radio();
        rad.setCurrentVolume(11);

        int expected = 0;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetCurrentVolumelessLimit() {
        Radio rad = new Radio();
        rad.setCurrentVolume(-1);

        int expected = 0;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }
}