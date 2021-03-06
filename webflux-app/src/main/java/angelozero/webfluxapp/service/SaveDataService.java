package angelozero.webfluxapp.service;

import angelozero.webfluxapp.repository.DataRepository;
import angelozero.webfluxapp.service.domain.DataDomain;
import angelozero.webfluxapp.service.mapper.DataServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SaveDataService {

    private final DataRepository dataRepository;
    private final DataServiceMapper mapper;

    public void execute(DataDomain dataDomain) {
        try {
            long id = (long) (Math.random() * (100));
            Mono.just(dataRepository.save(mapper.toEntity(id, dataDomain)));

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar o dado");
        }
    }
}
