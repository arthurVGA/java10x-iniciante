package org.artius.application;

import org.artius.application.menu.Menu;
import org.artius.application.menu.service.NinjaService;
import org.artius.application.repository.NinjaRepository;
import org.artius.application.utils.ScannerUtils;

import java.io.IOException;

public class Application {
    private static NinjaRepository ninjaRepository;
    private static NinjaService ninjaService;
    private static ScannerUtils scannerUtils;
    private static Menu ninjaMenu;

    public static void main(String[] args) throws IOException {
        int i;

        createInstances();

        do {
            i = ninjaMenu.openMenu();
        } while (i == 0);

        System.out.println("Sistema finalizado com sucesso!");
    }

    private static void createInstances() {
        scannerUtils = new ScannerUtils();
        ninjaRepository = new NinjaRepository();
        ninjaService = new NinjaService(ninjaRepository);
        ninjaMenu = new Menu(scannerUtils, ninjaService);
    }
}
