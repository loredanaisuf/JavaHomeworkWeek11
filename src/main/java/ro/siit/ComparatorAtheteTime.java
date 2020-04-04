package ro.siit;

import java.util.Comparator;

public class ComparatorAtheteTime implements Comparator<BiathlonAthlete> {
    @Override
    public int compare(BiathlonAthlete biathlonAthlete1, BiathlonAthlete biathlonAthlete2) {
        return biathlonAthlete1.getSkiTimeResult().compareTo(biathlonAthlete2.getSkiTimeResult());
    }
}
