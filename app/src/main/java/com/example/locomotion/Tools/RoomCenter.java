package com.example.locomotion.Tools;

import java.util.ArrayList;

public class RoomCenter {

    // parses room-JSON-object to ArrayList
    public static Double[] calculateAvg(ArrayList<Double[]> roomCoordinates){
        //TODO har vi tatt til høyde for mPerLong og mPerLAt når vi regner romsentrum?

        Double x_sum=0.0, y_sum = 0.0;
        int cnt = 0;
        for(int i = 0; i < roomCoordinates.size(); i++, cnt++){
            x_sum +=  roomCoordinates.get(i)[0];
            y_sum +=  roomCoordinates.get(i)[1];
        }

        Double x_avg = x_sum/cnt;
        Double y_avg = y_sum/cnt;
        Double[] avg = {x_avg,y_avg};

        // return avg-coordinates of x and y
        return avg;
    }
}
