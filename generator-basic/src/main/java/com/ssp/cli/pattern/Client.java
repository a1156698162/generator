package com.ssp.cli.pattern;

public class Client {
    public static void main(String[] args) {
        Device tv = new Device("tv");
        Device stereo = new Device("Stereo");

        TurnOnCommand turnOn = new TurnOnCommand(tv);
        TurnOffCommand turnOff = new TurnOffCommand(stereo);
        RemoteControl client = new RemoteControl();

        // 执行命令
        client.setCommand(turnOn);
        client.pressButton();

        client.setCommand(turnOff);
        client.pressButton();
    }
}
