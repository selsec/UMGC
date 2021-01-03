public class Lights {
    private boolean power;
    private int brightness;

    public Lights() {
        this.power = false;
        this.brightness = 100;
    }

    public void setPower(boolean changePower) {
        this.power = changePower;
    }

    public void setBrightness(int newBright) {
        this.brightness = newBright;
    }

    public int getBrightness() {
        return brightness;
    }
}
