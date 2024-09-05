package com.sysco.qe.util;

import com.syscolab.qe.core.common.LoggerUtil;

import java.io.*;
import java.util.Properties;

/**
 * This is the util class for PropertyFileReader
 */
public class PropertyFileReader {
    private Properties getData(String fileName) throws IOException {

        File file = new File("src/main/resources/testData/" + fileName + ".properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            LoggerUtil.logINFO(e.toString());
        }

        Properties prop = new Properties();

        try {
            prop.load(fileInput);
        } catch (IOException e) {
            LoggerUtil.logINFO(e.toString());
        }finally {
            if (fileInput != null) {
                fileInput.close();
            }
        }
        return prop;
    }

    public String getProperty(String fileName, String key) throws IOException {
        return getData(fileName).getProperty(key);
    }
}
