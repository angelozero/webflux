package angelozero.webfluxapp.service;

import angelozero.webfluxapp.repository.DataRepository;
import angelozero.webfluxapp.service.domain.DataDomain;
import angelozero.webfluxapp.service.mapper.DataServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindDataByIdService {

    private final DataRepository dataRepository;
    private final DataServiceMapper mapper;

    public Mono<DataDomain> execute(String id) {
        try {
            return dataRepository.findById(id).map(mapper::toDomain);

        } catch (Exception ex) {
            throw new RuntimeException(String.format("Erro ao consultar dados através do id %s", id));
        }
    }
}
