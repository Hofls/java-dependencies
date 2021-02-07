package hofls.com.github.postgres.campus;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CampusService {

    @Resource
    private CampusRepository campusRepository;

    public Campus findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Unknown ID!");
        }
        return campusRepository.findById(id).get();
    }

}
