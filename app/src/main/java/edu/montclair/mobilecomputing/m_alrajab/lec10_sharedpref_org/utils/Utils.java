package edu.montclair.mobilecomputing.m_alrajab.lec10_sharedpref_org.utils;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Utils {
    public static String[] getListOfFiles(Context context) {
        ArrayList<String> lst = new ArrayList<>();
        try {
            File[] files = context.getFilesDir().listFiles();
            boolean skip = true;
            for (File file : files)
                if (skip)
                    skip = false;
                else
                    lst.add(file.getName());
        } catch (Exception ignored) {
        }
        return lst.toArray(new String[lst.size()]);
    }

    public static String getContentOfFile(Context context, String title) {
        String tempStr = "";
        try {
            File[] files = context.getFilesDir().listFiles();
            for (File file : files)
                if (title.equals(file.getName())) {
                    FileInputStream inputStream = context.openFileInput(title);
                    int c;
                    while ((c = inputStream.read()) != -1) {
                        tempStr += Character.toString((char) c);
                    }
                    inputStream.close();
                }
        } catch (Exception ignored) {
        }
        return tempStr;
    }
}