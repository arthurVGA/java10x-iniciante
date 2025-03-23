package org.artius.application.menu;

import org.artius.application.domain.Ninja;
import org.artius.application.menu.service.NinjaService;
import org.artius.application.utils.ScannerUtils;

import java.util.InputMismatchException;
import java.util.List;

import static org.artius.application.utils.ValidateUtils.isStringContainsOnlyDigits;

public class Menu {
    private final ScannerUtils scanner;
    private final NinjaService ninjaService;

    public Menu(ScannerUtils scanner, NinjaService ninjaService) {
        this.scanner = scanner;
        this.ninjaService = ninjaService;
    }

    public int openMenu() {
        showMenu();
        String userChoice = scanner.getUserInputs();
        if(!isStringContainsOnlyDigits(userChoice)) {
            throw new InputMismatchException("Digite somento o número da opção.");
        }

        return executeOptionChosen(Integer.parseInt(userChoice));
    }

    private void showMenu() {
        System.out.println("""
                -----------------------------------------------------------------
                |                      Registro de Ninjas                       |
                |---------------------------------------------------------------|
                | Opções     |        1        |       2       |       3        |
                | Descrições | Cadastrar Ninja | Listar Ninjas | Fechar Sistema |
                -----------------------------------------------------------------
                """);

    }


    private int executeOptionChosen(int userOption) {
        switch (userOption) {
            case 1:
                return createNewNinja();
            case 2:
                return showAllNinjas();
            case 3:
                return closeSystem();
            default:
                System.err.println("Opção inválida! Por favor, digite a opção que está na entre a tela");
                return 0;
        }
    }

    private int createNewNinja() {
        System.out.println("Escreva o nome do ninja: ");
        String name = scanner.getUserInputs();

        System.out.println("Escreva a idade do ninja: ");
        String age = scanner.getUserInputs();

        System.out.println("Escreva o rank do ninja: ");
        String rank = scanner.getUserInputs();

        ninjaService.create(name, age, rank);
        return 0;
    }

    private int showAllNinjas() {
        List<Ninja> ninjas = ninjaService.retrieve();
        System.out.println("Lista de ninjas cadastrados");
        ninjas.forEach(ninja -> System.out.println(ninja.showAsString()));
        return 0;
    }

    private int closeSystem() {
        System.out.println("Finalizando sistema...");
        scanner.close();
        return -1;
    }

}
