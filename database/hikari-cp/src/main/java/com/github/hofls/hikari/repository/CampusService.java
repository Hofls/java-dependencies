package com.github.hofls.hikari.repository;

import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

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
