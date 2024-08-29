package com.example.demo.controller;

import com.example.demo.model.KhachHang;
import com.example.demo.model.NguoiTheo;
import com.example.demo.model.TheoXuKhach;
import com.example.demo.model.dto.req.TheoXuKHReqDTO;
import com.example.demo.model.dto.res.KhachHangResponseDTO;
import com.example.demo.model.dto.res.NguoiTheoDetailResponseDTO;
import com.example.demo.model.dto.res.NguoiTheoResponseDTO;
import com.example.demo.model.dto.res.TheoXuKhachResponseDTO;
import com.example.demo.service.INguoiTheoService;
import com.example.demo.service.ITheoXuKhachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/theoxukhach")
public class TheoXuKhachController {

    @Autowired
    private ITheoXuKhachService theoXuKhachService;

    @Autowired
    private INguoiTheoService nguoiTheoService;

    @PostMapping
    public ResponseEntity<TheoXuKhach> createTheoXuKhach(@RequestBody TheoXuKhach theoXuKhach) {
        if (theoXuKhach == null) {
            return ResponseEntity.badRequest().build();
        }
        TheoXuKhach savedTheoXuKhach = theoXuKhachService.save(theoXuKhach);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTheoXuKhach);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheoXuKhachResponseDTO> getTheoXuKhachById(@PathVariable Long id) {
        Optional<TheoXuKhach> theoXuKhachOptional = theoXuKhachService.findById(id);
        return theoXuKhachOptional.map(theoXuKhach -> ResponseEntity.ok(new TheoXuKhachResponseDTO(theoXuKhach)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TheoXuKhachResponseDTO>> getAllTheoXuKhach() {
        List<TheoXuKhach> theoXuKhachList = theoXuKhachService.findAll();
        List<TheoXuKhachResponseDTO> responseDTOList = theoXuKhachList.stream()
                .map(theoXuKhach -> {
                    TheoXuKhachResponseDTO dto = new TheoXuKhachResponseDTO(theoXuKhach);
                    dto.setTenKhachTheo(theoXuKhach.getKhachHang().getName()); // Thêm thông tin tên khách hàng
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOList);
    }

    @GetMapping("/nguoitheo/{id}")
    public ResponseEntity<List<TheoXuKhachResponseDTO>> getAllTheoXuKhachByNguoiTheo(@PathVariable Long id) {
        List<TheoXuKhach> theoXuKhachList = theoXuKhachService.findAllByIdNguoiTheo(id);
        if (theoXuKhachList.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 No Content nếu không có theo xu khách nào cho người theo này
        }
        List<TheoXuKhachResponseDTO> responseDTOList = theoXuKhachList.stream()
                .map(TheoXuKhachResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheoXuKhach(@PathVariable Long id) {
        if (!theoXuKhachService.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        theoXuKhachService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TheoXuKhachResponseDTO> updateTheoXuKhach(@PathVariable Long id, @RequestBody TheoXuKHReqDTO requestDTO) {
        if (requestDTO == null || requestDTO.getXuTheo() == null || requestDTO.getTenKhachTheo() == null || requestDTO.getTenKhachTheo().isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Trả về 400 Bad Request nếu dữ liệu không hợp lệ
        }

        Optional<TheoXuKhach> theoXuKhachOptional = theoXuKhachService.findById(id);
        if (!theoXuKhachOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Trả về 404 Not Found nếu không tìm thấy theo xu khách
        }

        TheoXuKhach theoXuKhach = theoXuKhachOptional.get();
        theoXuKhach.setXuTheo(requestDTO.getXuTheo());
        theoXuKhach.setNguoiTheo(nguoiTheoService.findById(requestDTO.getIdNguoiTheo()).get());

        TheoXuKhach updatedTheoXuKhach = theoXuKhachService.save(theoXuKhach);
        TheoXuKhachResponseDTO responseDTO = new TheoXuKhachResponseDTO(updatedTheoXuKhach);
        return ResponseEntity.ok(responseDTO); // Trả về 200 OK với thông tin theo xu khách đã cập nhật
    }
//    @GetMapping("/{id}/detail")
//    public ResponseEntity<NguoiTheoDetailResponseDTO> getNguoiTheoDetail(@PathVariable Long id) {
//        // Tìm kiếm NguoiTheo dựa trên id
//        Optional<NguoiTheo> nguoiTheoOptional = nguoiTheoService.findById(id);
//        if (!nguoiTheoOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Trả về 404 Not Found nếu không tìm thấy NguoiTheo
//        }
//
//        NguoiTheo nguoiTheo = nguoiTheoOptional.get();
//
//        // Lấy danh sách TheoXuKhach dựa trên id của NguoiTheo
//        List<TheoXuKhach> theoXuKhachList = theoXuKhachService.findAllByIdNguoiTheo(id);
//
//        // Lấy số lượng KhachHang
//        long khachHangCount = theoXuKhachList.stream()
//                .map(TheoXuKhach::getKhachHang)
//                .distinct()
//                .count();
//
//        // Tạo đối tượng DTO để trả về thông tin chi tiết NguoiTheo và số lượng KhachHang
//        NguoiTheoDetailResponseDTO responseDTO = new NguoiTheoDetailResponseDTO(nguoiTheo,theoXuKhachList.);
//
//        return ResponseEntity.ok(responseDTO); // Trả về 200 OK với thông tin chi tiết của NguoiTheo
//    }
}
