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
        String[] splitInput = input.split(",");
        BiathlonAthlete biathlonAthlete = new BiathlonAthlete(splitInput[0],splitInput[1],splitInput[2],splitInput[3],splitInput[4],splitInput[5],splitInput[6]);
        int result = biathlonAthlete.numbersOfO();
        assertEquals(3,result,0);
    }

    @Test
    public void Test2() {
        String input = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";
        String[] splitInput = input.split(",");
        
        BiathlonAthlete biathlonAthlete = new BiathlonAthlete(splitInput[0],splitInput[1],splitInput[2],splitInput[3],splitInput[4],splitInput[5],splitInput[6]);
        biathlonAthlete.changeTime(biathlonAthlete.numbersOfO()*10);
        String result = biathlonAthlete.getSkiTimeResult();

        assertTrue(result.equals("0:30:57"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ExceptionTest3(){
        String input = "11,Umar Jorgson,SK,30:27,xxxox,xxmxx,xxoxo";
        BiathlonAthlete.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ExceptionTest4(){
        String input = "1b1,Umar Jorgson,SK,30:27,xxoxx,xxxxo,xxoxo";
        BiathlonAthlete.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ExceptionTest5(){
        String input = "1b1,Umar Jorgson,SK,3c0:27,xxoxx,xxxxo,xxoxo";
        BiathlonAthlete.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ExceptionTest6(){
        String input = "11,Umar Jorgson,SK,3c0:27,xxoxx,xxxxoxxoxo";
        BiathlonAthlete.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ExceptionTest7(){
        String input = "11,Umar Jorgson,SK,30:27,xxoxx,xxxx0,xxoxo";
        BiathlonAthlete.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ExceptionTest8(){
        String input = "11,Umar Jorgson,SK,30:27,xxoxx,xxoxx0,xxoxo";
        BiathlonAthlete.validateInput(input);
    }
}
