package com.cidenet.application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Log {
    
    private static BufferedWriter bufferedReader;
    private static String path;
    private static Log instance;

    public Log(String path){
        if(instance == null)
            instance = this;
        this.path = path;
    }

    public Log(String path, boolean reset) throws IOException{
        if(instance == null)
            instance = this;
        this.path = path;
        open(!reset);
    }

    private static void open(boolean append) throws IOException{
        bufferedReader = new BufferedWriter(new FileWriter(path, append));
    }

    public static void addLine(String line) throws IOException{
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        String dateFormat = format.format(new Date());
        open(true);
        bufferedReader.write("[" + dateFormat + "]" + line + "\n");
        close();
    }

    public static String[] getLines() throws IOException{
        ArrayList<String> linesRead = new ArrayList<String>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line;
        while((line = bufferedReader.readLine()) != null){
            linesRead.add(line);
        }

        bufferedReader.close();

        String[] lines = new String[linesRead.size()];

        for(int i=0; i<linesRead.size(); i++){
            lines[i] = linesRead.get(i);
        }

        return lines;
    }

    public static void resetLog() throws IOException{
        open(false);
        close();
    }

    private static void close() throws IOException {
        bufferedReader.close();
    }


    public BufferedWriter getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedWriter bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static Log getInstance() {
        return instance;
    }

    public void setInstance(Log instance) {
        this.instance = instance;
    }


}
