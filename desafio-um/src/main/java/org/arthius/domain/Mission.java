package org.arthius.domain;

public class Mission {
    private String description;
    private char rank;
    private boolean isConcluded;
    private Ninja responsableNinja;

    public Mission(String description, char rank, Ninja responsableNinja) {
        this.description = description;
        this.rank = rank;
        this.responsableNinja = responsableNinja;
        this.setConcluded();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getRank() {
        return rank;
    }

    public void setRank(char rank) {
        this.rank = rank;
    }

    public Ninja getResponsableNinja() {
        return responsableNinja;
    }

    public void setResponsableNinja(Ninja responsableNinja) {
        this.responsableNinja = responsableNinja;
    }

    public void setConcluded() {
        if(responsableNinja.getAge() >= 15 || this.rank == 'E') {
            this.isConcluded = true;
        } else {
            this.isConcluded = false;
        }
    }

    public boolean isConcluded() {
        return isConcluded;
    }
}
