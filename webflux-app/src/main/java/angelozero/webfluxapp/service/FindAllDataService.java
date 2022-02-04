package angelozero.webfluxapp.service;

import angelozero.webfluxapp.repository.DataRepository;
import angelozero.webfluxapp.service.domain.DataDomain;
import angelozero.webfluxapp.service.mapper.DataServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllDataService {

    private final DataRepository dataRepository;
    private final DataServiceMapper mapper;

    public Mono<List<DataDomain>> execute() {
        try {
            return dataRepository.findAll().collectList().map(mapper::toDomainList);

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao consultar dados");
        }
    }
}
