package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {
    private int amountStation = 10;
    private int currentStation;
    private int currentVolume = 15;

    public Radio(int amountStation) {
        this.amountStation = amountStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation >= 0 && currentStation < amountStation) {
            this.currentStation = currentStation;
        }
    }

    public void next() {
        if (currentStation < amountStation - 1) {
            currentStation++;
        } else {
            currentStation = 0;
        }
    }

    public void prev() {
        if (currentStation > 0) {
            currentStation--;
        } else {
            currentStation = amountStation - 1;
        }
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume >= 0 && currentVolume <= 100) {
            this.currentVolume = currentVolume;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}
