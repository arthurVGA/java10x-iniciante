package org.arthius;

import org.arthius.domain.Mission;
import org.arthius.domain.Ninja;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Ninja naruto = new Ninja("Naruto", 16);
        Ninja neji = new Ninja("Neji", 14);
        Ninja shikamaru = new Ninja("Shikamaru", 15);
        Ninja sakura = new Ninja("Shikamaru", 14);

        Mission mission1 = new Mission("Gato pendurado na árvore.", 'E', neji);
        Mission mission2 = new Mission("Situação com reféns.", 'C', naruto);
        Mission mission3 = new Mission("Situação com reféns mais fácil.", 'D', shikamaru);
        Mission mission4 = new Mission("Situação com reféns mais fácil.", 'D', sakura);

        printMissionsSituations(mission1, mission2, mission3, mission4);
    }

    private static void printMissionsSituations(Mission...missions) {
        Arrays.stream(missions).forEach(Main::printMissionSituation);
    }

    private static void printMissionSituation(Mission mission) {
        System.out.println("-".repeat(43));

        printformatedInfo("| Missão: " + mission.getDescription());
        printformatedInfo("| Ninja responsável: " + mission.getResponsableNinja().getName());
        printformatedInfo("| Idade do Ninja: " + mission.getResponsableNinja().getName());
        printformatedInfo("| Rank da missão: " + mission.getRank());
        printformatedInfo("| Missão está concluída: " + mission.isConcluded());

        System.out.println("-".repeat(43) + "\n");
    }

    private static void printformatedInfo(String info) {
        int numberOfSpaces = 41 - info.length();
        System.out.println(info + " ".repeat(numberOfSpaces) + " |");
    }
}
