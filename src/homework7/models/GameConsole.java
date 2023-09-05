package homework7.models;

import homework7.constants.Brand;
import homework7.constants.Color;
import homework7.exceptions.ConsoleOffException;
import homework7.interfaces.Powered;

public class GameConsole implements Powered {

    private final Brand brand;
    private final String model;
    private final String serial;
    private Gamepad firstGamepad;
    private Gamepad secondGamepad;
    private boolean isOn;

    private Game activeGame;

    private int waitingCounter = 0;

    public GameConsole(Brand brand, String serial) {
        this.brand = brand;
        this.model = "PS5";
        this.serial = serial;
        this.firstGamepad = new Gamepad(brand, 1);
        this.secondGamepad = new Gamepad(brand, 2);
    }

    @Override
    public void powerOn() {
        if (isOn) {
            return;
        }
        isOn = true;
        if (!firstGamepad.isOn() && secondGamepad.isOn()) {
            secondGamepad.setConnectedNumber(1);
        }
    }

    @Override
    public void powerOff() {
        isOn = false;
        firstGamepad.setOn(false);
        secondGamepad.setOn(false);
    }

    public void connectSecondGamepadToFirst() {
        if (!firstGamepad.isOn()) {
            secondGamepad.setConnectedNumber(1);
            firstGamepad.powerOff();
        }
    }

    public void loadGame(Game game) {
        if (isOn) {
            System.out.println("Гра " + game.getName() + " завантажується");
            activeGame = game;
        } else {
            System.out.println("Приставка вимкнена. Не вдалося загрузити гру");
        }
    }

    public void playGame() {
        if (isOn && activeGame != null && (firstGamepad.isOn() || secondGamepad.isOn())) {
            System.out.println("Граєм в " + activeGame.getName());
            checkStatus();
        }
        else if(isOn && !firstGamepad.isOn() && !secondGamepad.isOn()){
            System.out.println("Підключіть джойстик");
        }else {
            System.out.println("Приставка вимкнена або гра не вибрана");
        }
    }

    private void checkStatus() {
        if (!firstGamepad.isOn() && !secondGamepad.isOn()) {
            waitingCounter++;
            System.out.println("Підключіть джойстик");
            if (waitingCounter >= 5) {
                powerOff();
                throw new ConsoleOffException("Приставка завершає роботу через відсутність активності");
            }
        } else {
            waitingCounter = 0;
        }

        if (firstGamepad.isOn()) {
            firstGamepad.reduceChargeLevel(10);
            if (firstGamepad.getChargeLevel() <= 0) {
                this.firstGamepad.setOn(false);
            }
            System.out.println("Заряд " + firstGamepad.connectedNumber + ": " + firstGamepad.chargeLevel);
        }

        if (secondGamepad.isOn()) {
            secondGamepad.reduceChargeLevel(10);
            if (secondGamepad.getChargeLevel() <= 0) {
                secondGamepad.setOn(false);
            }
            System.out.println("Заряд " + secondGamepad.connectedNumber + ": " + secondGamepad.chargeLevel);
        }
    }

    public Brand getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSerial() {
        return serial;
    }

    public Gamepad getFirstGamepad() {
        return firstGamepad;
    }

    public Gamepad getSecondGamepad() {
        return secondGamepad;
    }
    public void setSecondGamepad(Gamepad secondGamepad) {
        this.secondGamepad = secondGamepad;
    }

    public boolean isOn() {
        return isOn;
    }

    public Game getActiveGame() {
        return activeGame;
    }

    //-----------GAMEPAD-----------
    public class Gamepad implements Powered {

        private final Brand brand;
        private final String consoleSerial;
        private int connectedNumber;
        private Color color = Color.BLACK;
        private double chargeLevel = 100.0;
        private boolean isOn;

        public Gamepad(Brand brand, int connectedNumber) {
            this.brand = brand;
            this.consoleSerial = serial;
            this.connectedNumber = connectedNumber;
        }

        public void connectToConsole(GameConsole console) {
            if (console.isOn()) {
                console.setSecondGamepad(this);
            }
        }

        public void reduceChargeLevel(double amount) {
            chargeLevel -= amount;
        }

        @Override
        public void powerOn() {
            this.setOn(true);
        }

        @Override
        public void powerOff() {
            this.setOn(false);
        }

        public Brand getBrand() {
            return brand;
        }

        public String getConsoleSerial() {
            return consoleSerial;
        }

        public int getConnectedNumber() {
            return connectedNumber;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public double getChargeLevel() {
            return chargeLevel;
        }

        public void setChargeLevel(double chargeLevel) {
            this.chargeLevel = chargeLevel;
        }

        public boolean isOn() {
            return isOn;
        }

        public void setOn(boolean isOn) {
            this.isOn = isOn;
        }

        public void setConnectedNumber(int connectedNumber) {
            this.connectedNumber = connectedNumber;
        }
    }
}

