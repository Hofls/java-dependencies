package com.github.hofls.rest.patch.school.dto;

import com.github.hofls.rest.patch.common.Identifiable;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// In real project this class will be stored in a database (e.g. as jsonb)
@Data
public class School {

    private String address;

    private Long studentsCount;

    private List<SKEUnit> skeUnits;

    @Data
    public static class SKEUnit implements Identifiable {
        private UUID id;

        private LocalDate date;

        private Boolean active;
    }

}
