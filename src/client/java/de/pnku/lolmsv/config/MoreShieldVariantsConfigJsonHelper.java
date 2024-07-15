package de.pnku.lolmsv.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class MoreShieldVariantsConfigJsonHelper {
    private static File folder = new File("config");
    private static File moreshieldvariantsConfig;
    public static Gson configGson = new GsonBuilder().setPrettyPrinting().create();

    public static void init() {
        createConfig();
        readFromConfig();
        writeToConfig();
    }

    public static void createConfig() {
        if (!folder.exists()) {
            folder.mkdir();
        }
        if (folder.isDirectory()) {
        moreshieldvariantsConfig = new File(folder,"moreshieldvariants.json");
        if (!moreshieldvariantsConfig.exists()) {
            try {
                 moreshieldvariantsConfig.createNewFile();
                 String json = configGson.toJson(MoreShieldVariantsConfig.getInstance());
                 FileWriter writer = new FileWriter(moreshieldvariantsConfig);
                 writer.write(json);
                 writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
                }
            }
        }
    }

    public static void readFromConfig() {
        try {
            MoreShieldVariantsConfig config = configGson.fromJson(new FileReader(moreshieldvariantsConfig), MoreShieldVariantsConfig.class);
            MoreShieldVariantsConfig.getInstance().updateConfigs(config);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static void writeToConfig () {
        try {
                String json = configGson.toJson(MoreShieldVariantsConfig.getInstance());
                FileWriter writer = new FileWriter(moreshieldvariantsConfig, false);
                writer.write(json);
                writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
