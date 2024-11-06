package com.example.demo.controller;

import com.example.demo.model.PhanTramCoDong;
import com.example.demo.model.TheoXuKhach;
import com.example.demo.model.dto.req.PhanTramCoDongReqDTO;
import com.example.demo.model.dto.res.PhanTramCoDongResponseDTO;
import com.example.demo.repository.IPhanTramCoDongRepository;
import com.example.demo.service.ICoDongService;
import com.example.demo.service.IPhanTramCoDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/phantramcodong")
public class PhanTramCoDongController {
    @Autowired
    private IPhanTramCoDongService phanTramCoDongService;
    @Autowired
    private ICoDongService coDongService;
    @PostMapping
    public ResponseEntity<PhanTramCoDong> createPhanTramCoDong(@RequestBody PhanTramCoDong phanTramCoDong) {
            if (phanTramCoDong == null) {
                return ResponseEntity.badRequest().build();
            }
            PhanTramCoDong savedPhanTramCoDong = phanTramCoDongService.save(phanTramCoDong);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPhanTramCoDong);
        }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPhanTramCoDongById(@PathVariable Long id) {
        Optional<PhanTramCoDong> phanTramCoDongOptional = phanTramCoDongService.findById(id);
        if (!phanTramCoDongOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
       List<PhanTramCoDong> phanTramCoDongList = phanTramCoDongService.findAllByIdCoDong(id);
        return new ResponseEntity<>(phanTramCoDongList, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<PhanTramCoDongResponseDTO>> getAllPhanTramCoDong() {
        List<PhanTramCoDong> phanTramCoDongList = phanTramCoDongService.findAll();
        List<PhanTramCoDongResponseDTO> responseDTOList = phanTramCoDongList.stream()
                .map(phanTramCoDong  -> {
                    PhanTramCoDongResponseDTO dto = new PhanTramCoDongResponseDTO(phanTramCoDong);
                    dto.setTenCoDong(phanTramCoDong.getCoDong().getName());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOList);
    }
    @GetMapping("/codong/{id}")
    public ResponseEntity<List<PhanTramCoDongResponseDTO>> getAllPhanTramCoDongByCoDong(@PathVariable Long id) {
        List<PhanTramCoDong> phanTramCoDongList = phanTramCoDongService.findAllByIdCoDong(id);
        if (phanTramCoDongList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<PhanTramCoDongResponseDTO> responseDTOList = phanTramCoDongList.stream()
                .map(PhanTramCoDongResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOList);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhanTramCoDong(@PathVariable Long id) {
        if (!phanTramCoDongService.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        phanTramCoDongService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<PhanTramCoDongResponseDTO> updatePhanTramCoDong(@PathVariable Long id, @RequestBody PhanTramCoDongReqDTO requestDTO) {
        if (requestDTO == null || requestDTO.getPhanTramTheo() == null || requestDTO.getTenCoDong() == null || requestDTO.getTenCoDong().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        Optional<PhanTramCoDong> phanTramCoDongOptional = phanTramCoDongService.findById(id);
        if (!phanTramCoDongOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        PhanTramCoDong phanTramCoDong = phanTramCoDongOptional.get();
        phanTramCoDong.setPhanTramTheo(requestDTO.getPhanTramTheo());
        phanTramCoDong.setCoDong(coDongService.findById(requestDTO.getIdCoDong()).get());

       PhanTramCoDong updatedPhanTramCoDong = phanTramCoDongService.save(phanTramCoDong);
       PhanTramCoDongResponseDTO responseDTO = new PhanTramCoDongResponseDTO(updatedPhanTramCoDong);
       return ResponseEntity.ok(responseDTO);

    }

}




