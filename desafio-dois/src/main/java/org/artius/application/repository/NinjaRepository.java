package org.artius.application.repository;

import org.artius.application.domain.Ninja;
import org.artius.application.domain.Status;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class NinjaRepository extends IORepository<Ninja> {
    private static final String TABLE = "ninjas";
    private final List<Ninja> ninjas;

    public NinjaRepository() {
        ninjas = new ArrayList<>();
        ninjas.addAll(super.read(TABLE));
    }

    public void create(Ninja ninja) {
        ninjas.add(ninja);
    }

    public void createAndSave(Ninja ninja) {
        create(ninja);
        save(ninja);
    }

    public List<Ninja> retrieve() {
        return ninjas;
    }

    public void save(Ninja ninja) {
        writeLine(ninja, TABLE);
    }

    protected List<Ninja> formatRead(BufferedReader reader) {
        return reader
                .lines()
                .map(lines -> {
                    String[] columns = lines.split(";");
                    return new Ninja(columns[0], columns[1], Integer.parseInt(columns[2]), Status.valueOf(Integer.parseInt(columns[3])));
                })
                .toList();
    }
}
