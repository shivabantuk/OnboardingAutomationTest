package CollectionsTask14;

import java.io.*;
import java.util.*;


public class Config {
    private Properties config;

    private String configFileName;
    private List<String> defaultFileNames;

    public Config() throws IOException {
        this("config.properties");
    }

    public Config(String configFileName) throws IOException {
        this.configFileName = configFileName;
        reset();
    }

    private void reset() throws FileNotFoundException {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(configFileName)) {
            prop.load(fis);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String defFileNames = prop.getProperty("defaultFileNames");
        defaultFileNames = defaultFileNames == null ? new ArrayList<>() : Arrays.asList(defFileNames.split(","));
        Properties defaults = new Properties();
        for (String file : defaultFileNames) {
            file = file.trim();
            if (!file.isEmpty()) {
                try (FileInputStream fis = new FileInputStream(file + ".properties")) {
                    defaults.load(fis);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        config = new Properties(defaults);
        for (Map.Entry<Object, Object> entry : prop.entrySet()) {
            config.put(entry.getKey(), entry.getValue());
        }
    }
    public String get(String key) {
        return config.getProperty(key);
    }
    public void set(String key, String value) {
        config.setProperty(key, value);
    }

    public void remove(String key) {
        config.remove(key);
    }
    public void save() throws IOException {
        Properties toSave = new Properties();
        for(String key: config.stringPropertyNames()){
            boolean fromDefault = false;
            for(String defaultFileName : defaultFileNames) {
                Properties def = new Properties();
                try (FileInputStream fis = new FileInputStream(defaultFileName.trim() + ".properties")) {
                    def.load(fis);
                    if (def.containsKey(key)) {
                        fromDefault = true;
                        break;

                    }

                } catch (IOException e) {

                }
            }
            if(!fromDefault || !config.getProperty(key).equals(getDaultValue(key))){
                toSave.setProperty(key, config.getProperty(key));

            }
            }
        try(FileOutputStream fos = new FileOutputStream(configFileName)) {
            toSave.store(fos, null);
        }
        }
        private String getDaultValue(String key) throws FileNotFoundException {
        for(String file: defaultFileNames){
            Properties def = new Properties();
            try(FileInputStream fis = new FileInputStream(file.trim() + ".properties")){
                def.load(fis);
                if (def.containsKey(key)) {
                    return def.getProperty(key);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return null;
        }
    }



