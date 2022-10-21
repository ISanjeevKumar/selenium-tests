package common.components;

import com.google.gson.Gson;
import common.modelObjects.RunSettings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonHelper {

    public static RunSettings getRunSettings(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/resources/runSettings.json"));
            RunSettings targetObject = new Gson().fromJson(br, RunSettings.class);
            return  targetObject;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
