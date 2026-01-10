package com.caps.reservationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import java.util.Optional;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import jakarta.transaction.Transactional;

import com.caps.reservationapp.entity.DineTable;
import com.caps.reservationapp.response.DineTableDto;
import com.caps.reservationapp.repository.DineTableRepo;
import com.caps.reservationapp.entity.Reservation;
import com.caps.reservationapp.repository.ReservationRepo;

@Transactional
public class DineTableService {

  @Autowired
  private DineTableRepo dineTableRepo;

  @Autowired
  private ReservationRepo reservationRepo;

  @Autowired
  private ModelMapper mapper;

  public Optional<DineTableDto> getDineTableById(UUID id) {
    Optional<DineTable> dineTable = dineTableRepo.findById(id);
    if (dineTable.isEmpty()) {
      return Optional.empty();
    }
    DineTableDto dineTableDto = mapper.map(dineTable, DineTableDto.class);
    return Optional.of(dineTableDto);
  }

  public List<DineTableDto> getAllDineTables() {
    List<DineTableDto> dineTablesDto = new ArrayList<DineTableDto>();
    List<DineTable> dineTables = dineTableRepo.findAll();
    if (dineTables.isEmpty()) {
      return dineTablesDto;
    }
    dineTables.forEach(m -> dineTablesDto.add(mapper.map(m, DineTableDto.class)));
    return dineTablesDto;
  }

  public List<String> getAllTimes() {
    return List.of("11:00", "11:30", "12:00", "12:30",
            "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00",
            "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30",
            "20:00", "20:30", "21:00");
  }

  public List<String> getAvailableTimesByDateAndTable(String date, String tableId, String exemptReservationId) {
    List<String> allTimes = this.getAllTimes();
    List<String> takenTimes = new ArrayList<String>(); // empty
    List<Reservation> reservations = new ArrayList<Reservation>(); // empty

    // if (date == null) {
    //   if (tableId != null) {
    //     reservations.addAll(reservationRepo.findByTableId(tableId));
    //   }
    // } else {
    //   if (tableId == null) {
    //     reservations.addAll(reservationRepo.findByDate(date));
    //   } else {
    //     reservations.addAll(reservationRepo.findByDateAndTableId(date, tableId));
    //   }
    // }

    if (date != null && date != "" && tableId != null && tableId != "") {
      reservations.addAll(reservationRepo.findByDateAndTableId(date, tableId));
      if (!reservations.isEmpty() && exemptReservationId != null && exemptReservationId != "") {
        reservations.removeIf(reservation -> reservation.getId().toString().equals(exemptReservationId));
      }
    }

    if (reservations.isEmpty()) {
      return allTimes;
    } else {
      for (Reservation reservation : reservations) {
        int iStart = allTimes.indexOf(reservation.getStartTime());
        int iEnd = allTimes.indexOf(reservation.getEndTime());
        for (int i = iStart; i < iEnd; i++) {
          takenTimes.add(allTimes.get(i));
        }
      }
      return allTimes.stream().filter(time -> !takenTimes.contains(time)).toList();
    }
  }

}
