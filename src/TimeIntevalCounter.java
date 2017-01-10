/**
 * Created by belashdima on 09.07.16.
 */

public class TimeIntevalCounter {
    private int repeatTime;

    private double begin;
    private double end;

    public TimeIntevalCounter(int repeatTime) {
        /*this.repeatTime = repeatTime;
        y=1/ln(x/repeatTime);
        ln(x/repeatTime) = 1/y;
        x/repeatTime = e^(1/y);
        begin = repeatTime * Math.exp(1/2);
        end = repeatTime * Math.exp(1);
        begin = Math.exp(repeatTime);
        end = Math.log(repeatTime);*/
    }

    public double getDuration() {
        return end-begin;
    }
}
