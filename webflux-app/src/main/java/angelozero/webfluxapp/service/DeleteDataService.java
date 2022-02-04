package angelozero.webfluxapp.service;

import angelozero.webfluxapp.repository.DataRepository;
import angelozero.webfluxapp.service.domain.DataDomain;
import angelozero.webfluxapp.service.mapper.DataServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteDataService {

    private final FindDataByIdService findDataByIdService;
    private final DataRepository dataRepository;
    private final DataServiceMapper mapper;

    public void execute(DataDomain dataDomain) {
        try {
            Mono<DataDomain> dataToBeDeleted = findDataByIdService.execute(dataDomain.getId());

            if (Objects.nonNull(dataToBeDeleted)) {
                dataToBeDeleted.flatMap(data -> dataRepository.delete(mapper.toEntity(data))).then(Mono.just(dataToBeDeleted));
            }

        } catch (Exception ex) {
            throw new RuntimeException(String.format("Erro ao deletar o dado - id %s", dataDomain.getId()));
        }
    }
}
