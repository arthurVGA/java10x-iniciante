package org.artius.application.repository;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class IORepository<T> {
    private static final String RESOURCE_PATH = IORepository.class.getClassLoader().getResource("").getPath();

    protected abstract List<T> formatRead(BufferedReader reader);

    protected List<T> read(String table) {
        try {
            FileReader fileReader = new FileReader(RESOURCE_PATH + "/database/" + table + ".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<T> objects = formatRead(bufferedReader);

            bufferedReader.close();
            fileReader.close();

            return objects;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    protected void writeAll(List<T> lines, String table) {
        try {
            FileWriter fileWriter = new FileWriter(RESOURCE_PATH + "/database/" + table + ".txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            write(lines, bufferedWriter);

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Houve um problema ao salvar a tabela");
        }
    }

    private void write(List<T> lines, BufferedWriter writer) throws IOException {
        for (T line : lines) {
            writer.write(line.toString());
        }
    }

    protected void writeLine(T line, String table) {
        try {
            FileWriter fileWriter = new FileWriter(RESOURCE_PATH + "/database/" + table + ".txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            write(line, bufferedWriter);

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("Houve um problema ao salvar a tabela");
        }
    }

    private void write(T line, BufferedWriter writer) throws IOException {
        writer.write(line.toString());
    }

}
