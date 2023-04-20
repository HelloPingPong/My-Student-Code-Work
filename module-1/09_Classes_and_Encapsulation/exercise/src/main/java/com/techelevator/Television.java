package com.techelevator;

public class Television {
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void turnOff() {
        this.isOn = false;
    }
    public void turnOn() {
        this.isOn = true;
        this.currentChannel = 3;
        this.currentVolume = 2;

    }
    public void changeChannel(int newChannel) {
        // change to the newChannel only if
        // The TV is ON
        // if the value between 3 and 18
        if (isOn && newChannel >= 3 && newChannel <= 18) {
            this.currentChannel = newChannel;
        }
    }
    public void channelUp() {
        // change channel up if ON
        // If goes over 18 set to 3
        if (isOn) { //conditional if - if the tv is on
            this.currentChannel++; //specifies this channel, adds an increment of one to the current channel
            if (this.currentChannel > 18) { // when performing the incremental addition - it checks if it has gone above 18. if so it drops it to 3
                this.currentChannel = 3;
            }
        }
    }
    public void channelDown() {
    // change channel down if ON
    // if it goes below 3 set to 18
        if (isOn) {
            this.currentChannel--;
            if (this.currentChannel < 3) {
                this.currentChannel = 18;
            }
        }
    }
    public void raiseVolume() {
        if (isOn && currentVolume < 10) {
            this.currentVolume++;
        }
    }
    public void lowerVolume() {
        if (isOn && currentVolume > 0) {
            this.currentVolume--;
        }
    }



}

