package angelozero.webfluxapp.service;

import angelozero.webfluxapp.repository.DataRepository;
import angelozero.webfluxapp.repository.entity.DataEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DummyDataService {

    @Autowired
    private final DataRepository dataRepository;

    public void execute() {
        dataRepository.deleteAll()
                .thenMany(
                        Flux.just("1 - Angelo", "2 - Brune", "3 - Pietro", "4 - Everton")
                                .map(name -> DataEntity.builder()
                                        .id(UUID.randomUUID().toString())
                                        .name(name)
                                        .build())
                                .flatMap(dataRepository::save))
                .subscribe(System.out::println);
    }
}
