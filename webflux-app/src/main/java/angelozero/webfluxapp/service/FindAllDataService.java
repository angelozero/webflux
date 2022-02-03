package angelozero.webfluxapp.service;

import angelozero.webfluxapp.repository.DataRepository;
import angelozero.webfluxapp.service.domain.DataDomain;
import angelozero.webfluxapp.service.mapper.DataServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllDataService {

    private final DataRepository dataRepository;
    private final DataServiceMapper mapper;

    public List<DataDomain> execute() {
        try {
            return dataRepository.findAll().map(mapper::toDomain).collect(Collectors.toList()).toFuture().get();

        } catch (ExecutionException | InterruptedException ex) {
            throw new RuntimeException("Erro ao consultar dados");
        }
    }
}
