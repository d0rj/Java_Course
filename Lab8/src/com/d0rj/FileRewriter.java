package com.d0rj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileRewriter implements AutoCloseable {

    private final FileWriter writer;


    public FileRewriter(String fileName) throws IOException {
        writer = new FileWriter(fileName, false);
    }


    public FileRewriter(File file) throws IOException {
        writer = new FileWriter(file);
    }


    public void rewrite(String data) throws IOException {
        writer.write(data);
    }


    @Override
    public void close() throws Exception {
        writer.close();
    }
}
