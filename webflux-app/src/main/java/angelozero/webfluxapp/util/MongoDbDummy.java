package angelozero.webfluxapp.util;

import angelozero.webfluxapp.repository.DataRepository;
import angelozero.webfluxapp.repository.entity.DataEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@RequiredArgsConstructor
public class MongoDbDummy implements CommandLineRunner {

    @Autowired
    private final DataRepository dataRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n Iniciando comunicação com base de dados MONGO-DB - Webflux \n");

        dataRepository.deleteAll()
                .thenMany(
                        Flux.just("1 - Angelo", "2 - Brune", "3 - Pietro", "4 - Everton")
                                .map(name -> DataEntity.builder()
                                        .id(UUID.randomUUID().toString())
                                        .name(name)
                                        .build())
                                .flatMap(dataRepository::save))
                .subscribe(System.out::println);

        System.out.println("\n Finalizando comunicação com base de dados MONGO-DB - Webflux \n");
    }
}
