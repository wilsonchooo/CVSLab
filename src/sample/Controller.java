package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private ArrayList<Info> Data = new ArrayList<Info>()
    int Columns = 0;

    public Controller (String File) {
        Path pathToFile = Paths.get(File);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Info info = new Info(attributes);
                Data.add(info);
                line = br.readLine();
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

        public ArrayList <String> getColumnHeaders() {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < Data.size(); i ++) {
            temp.add(Data.get(i).retrieve(0));
        }
        return temp;
    }
    public List<String> getDataString(int column) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < Data.get(column).size(); i ++) {
            temp.add(Data.get(column).retrieve(i));
        }
        return temp;
    }

    public List<Integer> getDataInt(int column) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < Data.get(column).size(); i ++) {
            temp.add(Integer.getInteger(Data.get(column).retrieve(i)));
        }
        return temp;
    }

    public List<Double> getDataDouble(int column) {
        ArrayList<Double> temp = new ArrayList<>();
        for (int i = 0; i < Data.get(column).size(); i ++) {
            temp.add(Double.valueOf(Data.get(column).retrieve(i)));
        }
        return temp;
    }




}
