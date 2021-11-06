package de.htwberlin.webtech;

import de.htwberlin.webtech.api.Rezept;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RezeptRestController {

    private List<Rezept> recepies;

    public RezeptRestController(){
        recepies = new ArrayList<>();
        recepies.add(new Rezept(1, "Gurken", "Salat", true));
        recepies.add(new Rezept(2, "Hack", "mit Hack", false));
    }

    @GetMapping(path = "/api/v1/rezepte")
    public ResponseEntity<List<Rezept>> fetchRecepies() {
        return ResponseEntity.ok(recepies);
    }

}
