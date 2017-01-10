import java.text.SimpleDateFormat;
import java.util.*;

public class Main
{
    private static double func(double x) {
        return myExp(x)*10; //Math.exp(x)/0.1;
    }

    private static double func2(double x) {
        double sum=10;
        for (int i=1;i<x;i++) {
            sum = sum + i*10;
        }
        return sum;
    }

    public static Date addMinutes(Date date, int minutesNumber)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutesNumber); //minus number would decrement the days
        return cal.getTime();
    }

    public static void main(String[] args) {
        nextNotificationTimeGetter(20);
        /*for (int i= 1; i<12;i++) {
            System.out.println(nextNotificationTimeGetter(i));
        }*/
        /*Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat();
        System.out.println(date);
        String forThisMoment=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(addMinutes(new Date(),10));
        String thisMoment=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(addMinutes(new Date(),12));
        System.out.println("thisMoment+10= " + thisMoment);

        ArrayList<Double> moments = createNotifyMoments(23);
        for (Double value:moments) {
            Double d=value;
            if(d<60) System.out.println(d+" minutes");
            else if(d<1440) System.out.println(((int)(d/60))+" hours "+(d%60)+" minutes");
            else System.out.println(((int)(d/24/60))+" days "+((int)(d/60))+" hours "+(d%60)+" minutes");
        }
        System.out.println("moments.size() = " + moments.size());*/



        /*double before = 0;
        for (int i=0; i  < 12; i++) {
            double d = func(i);
            //if(d>14400) d=func2(i);
            if(d<60) System.out.println(d+" minutes");
            else if(d<1440) System.out.println(((int)(d/60))+" hours "+(d%60)+" minutes");
            else System.out.println(((int)(d/24/60))+" days "+((int)(d/60))+" hours "+(d%60)+" minutes");

            before = d;
            //System.out.println(d);
            //System.out.println(Math.exp(i)-Math.exp(i+1));
        }*/


        System.out.println();
        System.out.println();



    }

    public static Date nextNotificationTimeGetter(int numberOfNotification) {
        ArrayList<Double> notifyMoments = createNotifyMoments(numberOfNotification);
        System.out.println(notifyMoments);
        int minutesDifference = (int) Math.round(notifyMoments.get(numberOfNotification) - notifyMoments.get(numberOfNotification-1));
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, minutesDifference); //minus number would decrement the minutes
        //String dateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
        return cal.getTime();
    }

    private static ArrayList<Double> createNotifyMoments(int numberOfNotification) {
        ArrayList<Double> notifyMoments = new ArrayList<Double>();
        notifyMoments.add(0.0);

        int i=0;
        for (; i<12; i++) {
            notifyMoments.add(func(i));
        }

        if(numberOfNotification>=12) {
            while (i<numberOfNotification) {
                Random r = new Random();
                double rangeMin = 21600;
                double rangeMax = 43200;
                double randomValue = rangeMin + (rangeMax-rangeMin)*r.nextDouble();
                notifyMoments.add(randomValue);
                i++;
            }
        }

        return notifyMoments;
    }


    public static double myExp(double x) {
        ArrayList<Double> exps = new ArrayList<>();
        for (double i = 2.5; i >= 1.0 ; i=i-0.07) {
            exps.add(i);
        }
        // exp.size()=22

        double sum = 1;
        for (int i = 0; i < x; i++) {
            sum = sum * exps.get(i);
        }

        return sum;
    }
}
