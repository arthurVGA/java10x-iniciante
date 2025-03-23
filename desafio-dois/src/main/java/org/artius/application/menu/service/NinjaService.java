package org.artius.application.menu.service;

import org.artius.application.domain.Ninja;
import org.artius.application.domain.Status;
import org.artius.application.repository.NinjaRepository;

import java.util.InputMismatchException;
import java.util.List;

public class NinjaService {

    private final NinjaRepository repository;

    public NinjaService(NinjaRepository repository) {
        this.repository = repository;
    }

    public void create(String name, String age, String rank) {
        if(!name.matches ("[a-zA-Z ]+")) {
            throw new InputMismatchException("Nome do Ninja só pode conter letras");
        }
        if(!rank.matches ("[a-zA-Z]+")) {
            throw new InputMismatchException("Rank do Ninja só pode conter letras");
        }
        if(!age.matches ("[0-9]+")) {
            throw new InputMismatchException("Idade do Ninja só pode conter números");
        }

        repository.createAndSave(new Ninja(name, rank, Integer.parseInt(age), Status.ALIVE));
    }

    public List<Ninja> retrieve() {
        return repository.retrieve();
    }
}
