package org.artius.application.domain;

import java.util.Arrays;

public enum Status {
    ALIVE(1,"Ativo"),
    DEAD(0,"Inativo"),
    UNKNOWN(-1,"Desconhecido");

    private final int active;
    private final String description;

    Status(int active, String description) {
        this.active = active;
        this.description = description;
    }

    public int getActive() {
        return active;
    }

    public String getDescription() {
        return description;
    }

    public static Status valueOf(int active) {
        return Arrays.stream(Status.values())
                    .filter(status -> status.getActive() == active)
                    .findFirst()
                    .orElseGet(()-> Status.UNKNOWN);
    }

    @Override
    public String toString() {
        return "status: " + description;
    }
}
