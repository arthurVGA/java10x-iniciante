package org.artius.application.domain;

public record Ninja(String name, String rank, int age, Status status) {
    @Override
    public String toString() {
        return name + ";" + rank + ";" + age + ";" + status.getActive();
    }

    public String showAsString() {
        return "| NOME: " + name +
               "| RANK: " + rank +
               "| IDADE: " + age +
               "| STATUS: " + status.getDescription() +
                " |";
    }

}
