package com.example.locomotion.Json;

import com.example.locomotion.Datatype.PathInfo;


import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class JSONPath {

    public static ArrayList<Integer> elevatorIndex = new ArrayList<>(); // marks elements which enter Elevator
    public static ArrayList<Double[]> coordinateArr = new ArrayList<>();
    private static ParseJSON parseJson = new ParseJSON();

    //   public static void main(String args[]) throws IOException, ParseException, JSONException {    }
    public static JSONObject parseURL(String url) throws JSONException, ParseException, IOException {
        JSONObject jsonObject = parseJson.readJsonFromUrl(url);
        return jsonObject;
    }


    public static PathInfo pathData (JSONObject jsonObject)
    {            // Returns instance of PathInfo-class
        PathInfo pathInfo = new PathInfo();                             // new instance of PathInfo

        try {
            JSONArray fullCoorArr = new JSONArray();

            JSONArray featuresArray = (JSONArray) ((JSONObject) jsonObject.get("path")).get("features");
            for (int i = 0; i < featuresArray.size(); i++) {
                JSONObject featuresObj = (JSONObject) featuresArray.get(i);
                JSONArray coorArr = (JSONArray) ((JSONObject) featuresObj.get("geometry")).get("coordinates");
                JSONObject propertiesObj = (JSONObject) featuresObj.get("properties");
                JSONArray flagArr = ((JSONArray) propertiesObj.get("flags"));
                boolean elevator = ((flagArr.toString()).toUpperCase()).contains("ELEVATOR");
                JSONArray temp_0 = (JSONArray) coorArr.get(0);
                JSONArray temp_1 = (JSONArray) coorArr.get(1);
                Double[] xy_0 = {(Double) temp_0.get(0), (Double) temp_0.get(1)};
                Double[] xy_1 = {(Double) temp_1.get(0), (Double) temp_1.get(1)};

                if (i == 0) {
                    if (elevator) {           // adds index of coordinate-pair to enter Elevator into elevatorIndex
                        pathInfo.flagIndexes.add(i + 1);
                    }
                    PathInfo.coordinateArray.add(xy_0);
                    PathInfo.coordinateArray.add(xy_1);
                } else {
                    if (elevator) {           // adds index of coordinate-pair to enter Elevator into elevatorIndex
                        pathInfo.flagIndexes.add(i + 1);
                    }
                    PathInfo.coordinateArray.add(xy_1);
                }
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        printIndex(pathInfo.flagIndexes);
        // printCoordinates(pathInfo.coordinateArray, pathInfo.flagIndexes);
        return pathInfo;                                                        // returns instance of pathInfo-class
    }
    private static void printIndex (ArrayList< Integer > flagIndex) {
        for (int jj = 0; jj < flagIndex.size(); jj++) {

        }
    }
}