package angelozero.webfluxapp.controller;

import angelozero.webfluxapp.controller.mapper.DataRestMapper;
import angelozero.webfluxapp.controller.rest.DataRestRequest;
import angelozero.webfluxapp.controller.rest.DataRestResponse;
import angelozero.webfluxapp.service.DeleteDataService;
import angelozero.webfluxapp.service.DummyDataService;
import angelozero.webfluxapp.service.FindAllDataService;
import angelozero.webfluxapp.service.FindDataByIdService;
import angelozero.webfluxapp.service.SaveAllDataService;
import angelozero.webfluxapp.service.SaveDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
@RestController()
@RequestMapping("webflux")
public class DataController {

    private final DummyDataService dummyDataService;

    private final FindAllDataService findAllDataService;
    private final FindDataByIdService findDataByIdService;
    private final SaveDataService saveDataService;
    private final SaveAllDataService saveAllDataService;
    private final DeleteDataService deleteDataService;

    private final DataRestMapper mapper;

    @PostMapping("dummy")
    public ResponseEntity<String> insertDummyData() {
        dummyDataService.execute();
        return ResponseEntity.ok("Dummy Data inserida com sucesso");
    }

    @GetMapping("all")
    public ResponseEntity<Mono<List<DataRestResponse>>> get() {
        return ResponseEntity.ok(findAllDataService.execute().map(mapper::toResponseList));
    }

    @GetMapping("id")
    public ResponseEntity<Mono<DataRestResponse>> getById(@RequestParam String id) {
        return ResponseEntity.ok(findDataByIdService.execute(id).map(mapper::toResponse));
    }

    @PostMapping("save")
    public ResponseEntity<String> save(@RequestBody DataRestRequest dataRestRequest) {
        saveDataService.execute(mapper.toDomain(dataRestRequest));
        return ResponseEntity.ok("Data inserida com sucesso");
    }

    @PostMapping("save-all")
    public ResponseEntity<String> saveAll(@RequestBody List<DataRestRequest> dataRestRequest) {
        saveAllDataService.execute(mapper.toDomainList(dataRestRequest));
        return ResponseEntity.ok("Datas inseridas com sucesso");
    }

    @PostMapping("delete")
    public ResponseEntity<String> delete(@RequestBody DataRestRequest dataRestRequest) {
        deleteDataService.execute(mapper.toDomain(dataRestRequest));
        return ResponseEntity.ok("Data excluída com sucesso");
    }
}
