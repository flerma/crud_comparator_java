package br.com.amil.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProjectUtils {
	
	public static ArrayList<String> read(final File textFile) {

        ArrayList<String> list = new ArrayList<String>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(
                            textFile.getAbsolutePath()));

            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
