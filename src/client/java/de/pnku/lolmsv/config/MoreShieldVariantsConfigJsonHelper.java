package de.pnku.lolmsv.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.pnku.lolmsv.MoreShieldVariants;

import java.io.*;
import java.nio.file.*;

public class MoreShieldVariantsConfigJsonHelper {
    private static final File folder = new File("config");
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
        boolean seemsValid;
        if (moreshieldvariantsConfig.exists()) {
            try {
                String moreshieldvariantsConfigJson = Files.readString(Path.of(moreshieldvariantsConfig.getPath()));
                seemsValid = moreshieldvariantsConfigJson.trim().startsWith("{");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else { seemsValid = true; }
        if (!moreshieldvariantsConfig.exists() || !seemsValid) {
            if (!seemsValid) {MoreShieldVariants.LOGGER.info("Found invalid config file, creating new config file at './config/moreshieldvariants.json'.");}
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
