package angelozero.webfluxapp.controller;

import angelozero.webfluxapp.service.DummyDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController()
@RequestMapping("webflux")
public class DataController {

    private final DummyDataService service;

    @GetMapping("dummy")
    public ResponseEntity<String> get() {
        service.execute();
        return ResponseEntity.ok("Sucesso");
    }
}
