package com.github.hofls.postgres.campus;

import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

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
