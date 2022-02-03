package angelozero.webfluxapp.service;

import angelozero.webfluxapp.repository.DataRepository;
import angelozero.webfluxapp.service.domain.DataDomain;
import angelozero.webfluxapp.service.mapper.DataServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class FindDataByIdService {

    private final DataRepository dataRepository;
    private final DataServiceMapper mapper;

    public DataDomain execute(String id) {
        try {
            return dataRepository.findById(id).map(mapper::toDomain).toFuture().get();

        } catch (ExecutionException | InterruptedException ex) {
            throw new RuntimeException(String.format("Erro ao consultar dados através do id %s", id));
        }
    }
}
