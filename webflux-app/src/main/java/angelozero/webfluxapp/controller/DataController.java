package angelozero.webfluxapp.controller;

import angelozero.webfluxapp.controller.mapper.DataRestMapper;
import angelozero.webfluxapp.controller.rest.DataRestRequest;

import angelozero.webfluxapp.controller.rest.DataRestResponse;
import angelozero.webfluxapp.service.DummyDataService;
import angelozero.webfluxapp.service.FindAllDataService;
import angelozero.webfluxapp.service.FindDataByIdService;
import angelozero.webfluxapp.service.SaveDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController()
@RequestMapping("webflux")
public class DataController {

    private final FindAllDataService findAllDataService;
    private final FindDataByIdService findDataByIdService;
    private final SaveDataService saveDataService;
    private final DummyDataService dummyDataService;
    private final DataRestMapper mapper;

    @PostMapping("dummy")
    public ResponseEntity<String> insertDummyData() {
        dummyDataService.execute();
        return ResponseEntity.ok("Dummy Data inserida com sucesso");
    }

    @GetMapping("all")
    public ResponseEntity<List<DataRestResponse>> get() {
        return ResponseEntity.ok(mapper.toResponse(findAllDataService.execute()));
    }

    @GetMapping("id")
    public ResponseEntity<DataRestResponse> getById(@RequestParam String id) {
        return ResponseEntity.ok(mapper.toResponse(findDataByIdService.execute(id)));
    }

    @PostMapping("save")
    public ResponseEntity<String> save(@RequestBody DataRestRequest dataRestRequest) {
        saveDataService.execute(mapper.toDomain(dataRestRequest));
        return ResponseEntity.ok("Data inserida com sucesso");
    }
}
