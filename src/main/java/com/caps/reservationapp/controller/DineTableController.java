package com.caps.reservationapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.caps.reservationapp.response.DineTableDto;
import com.caps.reservationapp.service.DineTableService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DineTableController {

    @Autowired
    private DineTableService dineTableService;

    @GetMapping("/tables/{id}")
    private ResponseEntity<DineTableDto> getTable(@PathVariable UUID id) {
        Optional<DineTableDto> table = dineTableService.getDineTableById(id);
        if (table.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(table.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("/tables")
    private ResponseEntity<List<DineTableDto>> getAllTables() {
        List<DineTableDto> tables = dineTableService.getAllDineTables();
        return ResponseEntity.status(HttpStatus.OK).body(tables);
    }

    @GetMapping("/times/available")
    public ResponseEntity<List<String>> getAvailableTimesByDateAndTable(
        @RequestParam(required = false) String date,
        @RequestParam(required = false) String tableId,
        @RequestParam(required = false) String exemptReservationId
    ) {
        List<String> times = dineTableService.getAvailableTimesByDateAndTable(date, tableId, exemptReservationId);
        return ResponseEntity.status(HttpStatus.OK).body(times);
    }

    @GetMapping("times")
    public List<String> getAllTimes() {
        return dineTableService.getAllTimes();
    }
    
    

}
