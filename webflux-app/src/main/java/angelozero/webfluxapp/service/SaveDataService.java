package angelozero.webfluxapp.service;

import angelozero.webfluxapp.repository.DataRepository;
import angelozero.webfluxapp.service.domain.DataDomain;
import angelozero.webfluxapp.service.mapper.DataServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaveDataService {

    private final DataRepository dataRepository;
    private final DataServiceMapper mapper;

    public void execute(DataDomain dataDomain) {
        try {
            dataRepository.save(mapper.toEntity(UUID.randomUUID().toString(), dataDomain)).toFuture().get();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar os dados");
        }
    }
}
