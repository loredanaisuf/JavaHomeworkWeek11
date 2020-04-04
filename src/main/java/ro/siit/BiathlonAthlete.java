package ro.siit;


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
        int sec = parseInt(score[1]);
        int min = parseInt(score[0]);

        sec+=n*10;
        if(sec>=60 && sec<120){
            sec-=60;
            min++;
        }
        if(sec>=120 && sec<180){
            sec-=120;
            min+=2;
        }
        if(sec>=180 && sec<210){
            sec-=180;
            min+=3;
        }

        this.skiTimeResult = min + ":" + sec;
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
