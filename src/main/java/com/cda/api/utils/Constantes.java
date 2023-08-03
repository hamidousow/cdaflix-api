package com.cda.api.utils;

import java.io.File;
import java.io.IOException;

public class Constantes {

    public static final String FOLDER_PATH;

    static {
        try {
            FOLDER_PATH = new File(".").getCanonicalPath()+"\\src\\main\\resources\\images\\";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
