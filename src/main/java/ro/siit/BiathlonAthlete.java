package ro.siit;


import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.Integer.parseInt;

public class BiathlonAthlete {
    private String number;
    private String name;
    private String countryCode;
    private String skiTimeResult;
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;
    private String anteriorSkiTimeResult;

    public BiathlonAthlete(String number, String name, String countryCode, String skiTimeResult, String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public String getName() {
        return name;
    }

    public String getAnteriorSkiTimeResult() {
        return anteriorSkiTimeResult;
    }

    public int numbersOfO(){
        int count = 0;
        for(int i=0; i<this.firstShootingRange.length();i++){
            if(this.firstShootingRange.charAt(i) == 'o'){
                count++;
            }
        }
        for(int i=0; i<this.secondShootingRange.length();i++){
            if(this.secondShootingRange.charAt(i) == 'o'){
                count++;
            }
        }
        for(int i=0; i<this.thirdShootingRange.length();i++){
            if(this.thirdShootingRange.charAt(i) == 'o'){
                count++;
            }
        }
        return count;
    }


    public void changeTime(int n){
        anteriorSkiTimeResult = skiTimeResult;
        String[] score = skiTimeResult.split(":");

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if(score.length==2){
            gregorianCalendar.set(Calendar.HOUR,0);
            gregorianCalendar.set(Calendar.MINUTE,Integer.parseInt(score[0]));
            gregorianCalendar.set(Calendar.SECOND,Integer.parseInt(score[1]));
        }
        else {
            gregorianCalendar.set(Calendar.HOUR,Integer.parseInt(score[0]));
            gregorianCalendar.set(Calendar.MINUTE,Integer.parseInt(score[1]));
            gregorianCalendar.set(Calendar.SECOND,Integer.parseInt(score[2]));
        }

        gregorianCalendar.add(Calendar.SECOND,n);
        int h = gregorianCalendar.get(Calendar.HOUR);
        int min = gregorianCalendar.get(Calendar.MINUTE);
        int sec = gregorianCalendar.get(Calendar.SECOND);

        this.skiTimeResult = h + ":" + min + ":" + sec;
    }

    public static void validateInput(String input) throws IllegalArgumentException{
        String[] splitInput = input.split(",");
        if(splitInput.length != 7){
            System.out.println("Wrong input!");
            throw new IllegalArgumentException("Wrong input!");
        }

        if(Integer.parseInt(splitInput[0])<0){
            System.out.println("Wrong input! On the first pozition have to be a number!");
            throw new IllegalArgumentException("Wrong input! On the first pozition have to be a number!");
        }

        String time = splitInput[3];
        String[] splitTime = time.split(":");
        for(int i=0; i<splitTime.length; i++) {
            if (Integer.parseInt(splitTime[i]) < 0) {
                System.out.println("Wrong input! Time is not correct!");
                throw new IllegalArgumentException("Wrong input! Time is not correct!");
            }
        }

        if(splitInput[4].length()!=5 || splitInput[5].length()!= 5 || splitInput[6].length()!=5){
            System.out.println("Wrong input! Incorrect shooting range1!");
            throw new IllegalArgumentException("Wrong input! Incorrect shooting range!");
        }


        for(int i=0; i<splitInput[4].length(); i++){
            if((splitInput[4].charAt(i)!='x' && splitInput[4].charAt(i)!='o') ||
                    (splitInput[5].charAt(i)!='x' && splitInput[5].charAt(i)!='o') ||
                    (splitInput[6].charAt(i)!='x' && splitInput[6].charAt(i)!='o')){
                System.out.println("Wrong input! Incorrect shooting range2!");
                throw new IllegalArgumentException("Wrong input! Incorrect shooting range!");
            }
        }
    }

    @Override
    public String toString() {
        return "BiathlonAthlete{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", skiTimeResult='" + skiTimeResult + '\'' +
                ", firstShootingRange='" + firstShootingRange + '\'' +
                ", secondShootingRange='" + secondShootingRange + '\'' +
                ", thirdShootingRange='" + thirdShootingRange + '\'' +
                '}';
    }
}
