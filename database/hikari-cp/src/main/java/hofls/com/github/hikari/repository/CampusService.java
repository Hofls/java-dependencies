package hofls.com.github.hikari.repository;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CampusService {

    @Resource
    private CampusRepository campusRepository;

    public Campus save(String name) {
        Campus campus = new Campus();
        campus.setName(name);
        return campusRepository.save(campus);
    }

}
