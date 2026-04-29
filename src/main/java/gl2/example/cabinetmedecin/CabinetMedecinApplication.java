package gl2.example.cabinetmedecin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabinetMedecinApplication {

    public static void main(String[] args) {
        SpringApplication.run(CabinetMedecinApplication.class, args);
        System.out.println("=========================================");
        System.out.println("  Cabinet Medical demarre sur port 8080");
        System.out.println("  Console H2 : http://localhost:8080/h2-console");
        System.out.println("=========================================");
    }
}
