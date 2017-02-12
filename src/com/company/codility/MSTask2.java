package com.company.codility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by aliasghar on 04/02/2017.
 */
public class MSTask2 {
    public int solution(String S) {

        Character char10 = 10;
        String[] logLines = S.split(char10.toString());
        Map<String, Integer> phoneBill = new HashMap<>();

        int maxSoFar = 0;
        for(String logLine : logLines){
            //2 elements [time,number]
            String[] lineSplit = logLine.split(",");
            if(lineSplit.length < 2)
                continue;

            int cost = calculateCost(lineSplit[0]);

            if(phoneBill.containsKey(lineSplit[1])){
                cost = phoneBill.get(lineSplit[1]) + cost;
            }
            phoneBill.put(lineSplit[1], cost);
            if(cost > maxSoFar){
                maxSoFar = cost;
            }
        }

        int billToPay = 0;
        boolean applyDiscount = false;
        Iterator phoneNumber = phoneBill.entrySet().iterator();
        while (phoneNumber.hasNext()) {
            Map.Entry pair = (Map.Entry)phoneNumber.next();

            // Given we don't have to return the phone numbers, we just have to
            // make sure in the case of a tie, the discount is only applied once
            if(((int)pair.getValue()) == maxSoFar && !applyDiscount){
                applyDiscount = true;
            }
            else{
                billToPay += (int)pair.getValue();
            }
        }
        return billToPay;
    }

    private int returnSeconds(String timeStr){
        String[] time = timeStr.split(":");
        int seconds = 0;
        seconds += Integer.parseInt(time[2]);               // seconds
        seconds += (60*Integer.parseInt(time[1]));          // minutes
        seconds += (60*60*Integer.parseInt(time[0]));       // hours
        return seconds;
    }
    private int returnMinutes(String timeStr){
        String[] time = timeStr.split(":");
        int minutes = 0;
        minutes += Integer.parseInt(time[2]) > 0 ? 1 : 0;   // seconds
        minutes += (Integer.parseInt(time[1]));             // minutes
        minutes += (60*Integer.parseInt(time[0]));          // hours
        return minutes;
    }
    // In cents
    private int calculateCost(String timeStr){
        int mins = returnMinutes(timeStr);
        if(mins >= 5) {
            return mins * 150;
        }
        else{
            return returnSeconds(timeStr)*3;
        }
    }
}
