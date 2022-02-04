package angelozero.webfluxapp.service;

import angelozero.webfluxapp.repository.DataRepository;
import angelozero.webfluxapp.service.domain.DataDomain;
import angelozero.webfluxapp.service.mapper.DataServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaveAllDataService {

    private final DataRepository dataRepository;
    private final DataServiceMapper mapper;

    public void execute(List<DataDomain> dataDomain) {
        try {
            Flux.just(dataRepository.saveAll(mapper.toEntityList(dataDomain)));

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar o dado");
        }
    }
}
