package ro.siit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void Test1() {
        String input = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";
        BiathlonAthlete.validateInput(input);
        String[] splitInput = input.split(",");
        BiathlonAthlete biathlonAthlete = new BiathlonAthlete(splitInput[0],splitInput[1],splitInput[2],splitInput[3],splitInput[4],splitInput[5],splitInput[6]);
        int result = biathlonAthlete.numbersOfO();
        assertEquals(3,result,0);
    }

    @Test
    public void Test2() {
        String input = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";
        BiathlonAthlete.validateInput(input);
        String[] splitInput = input.split(",");

        BiathlonAthlete biathlonAthlete = new BiathlonAthlete(splitInput[0],splitInput[1],splitInput[2],splitInput[3],splitInput[4],splitInput[5],splitInput[6]);
        biathlonAthlete.changeTime(biathlonAthlete.numbersOfO()*10);
        String result = biathlonAthlete.getSkiTimeResult();

        assertTrue(result.equals("0:30:57"));
    }

    @Test
    public void Test3() {
        String input = "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo";
        String[] splitInput = input.split(",");
        BiathlonAthlete.validateInput(input);
        BiathlonAthlete biathlonAthlete = new BiathlonAthlete(splitInput[0],splitInput[1],splitInput[2],splitInput[3],splitInput[4],splitInput[5],splitInput[6]);
        biathlonAthlete.changeTime(biathlonAthlete.numbersOfO()*10);
        String result = biathlonAthlete.getSkiTimeResult();

        assertTrue(result.equals("0:30:15"));
    }

    @Test
    public void Test4(){
        String input = "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo";
        String[] splitInput = input.split(",");
        BiathlonAthlete.validateInput(input);
        BiathlonAthlete biathlonAthlete = new BiathlonAthlete(splitInput[0],splitInput[1],splitInput[2],splitInput[3],splitInput[4],splitInput[5],splitInput[6]);
        biathlonAthlete.changeTime(2500);
        String result = biathlonAthlete.getSkiTimeResult();

        assertTrue(result.equals("1:10:55"));
    }

    @Test
    public void Test5(){
        String input1 = "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo";
        String[] splitInput1 = input1.split(",");
        BiathlonAthlete.validateInput(input1);

        String input2 = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";
        String[] splitInput2 = input2.split(",");
        BiathlonAthlete.validateInput(input2);

        String input3 = "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";
        String[] splitInput3 = input3.split(",");
        BiathlonAthlete.validateInput(input3);


        BiathlonAthlete biathlonAthlete1 = new BiathlonAthlete(splitInput1[0],splitInput1[1],splitInput1[2],splitInput1[3],splitInput1[4],splitInput1[5],splitInput1[6]);
        BiathlonAthlete biathlonAthlete2 = new BiathlonAthlete(splitInput2[0],splitInput2[1],splitInput2[2],splitInput2[3],splitInput2[4],splitInput2[5],splitInput2[6]);
        BiathlonAthlete biathlonAthlete3 = new BiathlonAthlete(splitInput3[0],splitInput3[1],splitInput3[2],splitInput3[3],splitInput3[4],splitInput3[5],splitInput3[6]);

        biathlonAthlete1.changeTime(biathlonAthlete1.numbersOfO()*10);
        biathlonAthlete2.changeTime(biathlonAthlete2.numbersOfO()*10);
        biathlonAthlete3.changeTime(biathlonAthlete3.numbersOfO()*10);

        Set<BiathlonAthlete> biathlonAthleteListSorted = new TreeSet<>(new ComparatorAtheteTime());
        biathlonAthleteListSorted.add(biathlonAthlete1);
        biathlonAthleteListSorted.add(biathlonAthlete2);
        biathlonAthleteListSorted.add(biathlonAthlete3);

        String result = ((TreeSet<BiathlonAthlete>) biathlonAthleteListSorted).first().getName();
        assertTrue(result.equals("Piotr Smitzer"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ExceptionTest1(){
        String input = "11,Umar Jorgson,SK,30:27,xxxox,xx0xx,xxoxo";
        BiathlonAthlete.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ExceptionTest2(){
        String input = "1b1,Umar Jorgson,SK,30:27,xxoxx,xxxxo,xxoxo";
        BiathlonAthlete.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ExceptionTest3(){
        String input = "1b1,Umar Jorgson,SK,3c0:27,xxoxx,xxxxo,xxoxo";
        BiathlonAthlete.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ExceptionTest4(){
        String input = "11,Umar Jorgson,SK,3c0:27,xxoxx,xxxxoxxoxo";
        BiathlonAthlete.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ExceptionTest5(){
        String input = "11,Umar Jorgson,SK,30:27,xxoxx,xxoxx0,xxoxo";
        BiathlonAthlete.validateInput(input);
    }
}
