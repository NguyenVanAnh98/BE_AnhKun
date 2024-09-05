package com.example.demo.controller;

import com.example.demo.model.NguoiTheo;
import com.example.demo.model.TheoXuKhach;
import com.example.demo.model.dto.KhachHangDTO;
import com.example.demo.model.dto.req.NguoiTheoRequestDTO;
import com.example.demo.model.dto.res.NguoiTheoDetailResponseDTO;
import com.example.demo.model.dto.res.NguoiTheoResponseDTO;
import com.example.demo.service.INguoiTheoService;
import com.example.demo.service.TheoXuKhachService;
import com.example.demo.service.TinhTienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/nguoitheo")
public class NguoiTheoController {

    @Autowired
    private INguoiTheoService nguoiTheoService;
    @Autowired
    private TheoXuKhachService theoXuKhachService;
    @Autowired
    private TinhTienService tinhTienService;

    @PostMapping
    public ResponseEntity<NguoiTheoResponseDTO> createNguoiTheo(@RequestBody NguoiTheoRequestDTO requestDTO) {
        if (requestDTO == null || requestDTO.getName() == null || requestDTO.getName().isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Trả về 400 Bad Request nếu dữ liệu không hợp lệ
        }

        NguoiTheo nguoiTheo = new NguoiTheo();
        nguoiTheo.setName(requestDTO.getName());

        NguoiTheo savedNguoiTheo = nguoiTheoService.save(nguoiTheo);
        NguoiTheoResponseDTO responseDTO = new NguoiTheoResponseDTO(savedNguoiTheo);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO); // Trả về 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<NguoiTheoResponseDTO> updateNguoiTheo(@PathVariable Long id, @RequestBody NguoiTheoRequestDTO requestDTO) {
        if (requestDTO == null || requestDTO.getName() == null || requestDTO.getName().isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Trả về 400 Bad Request nếu dữ liệu không hợp lệ
        }

        Optional<NguoiTheo> nguoiTheoOptional = nguoiTheoService.findById(id);
        if (!nguoiTheoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Trả về 404 Not Found nếu không tìm thấy người theo
        }

        NguoiTheo nguoiTheo = nguoiTheoOptional.get();
        nguoiTheo.setName(requestDTO.getName());

        NguoiTheo updatedNguoiTheo = nguoiTheoService.save(nguoiTheo);
        NguoiTheoResponseDTO responseDTO = new NguoiTheoResponseDTO(updatedNguoiTheo);
        return ResponseEntity.ok(responseDTO); // Trả về 200 OK với thông tin người theo đã cập nhật
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNguoiTheo(@PathVariable Long id) {
        Optional<NguoiTheo> nguoiTheoOptional = nguoiTheoService.findById(id);
        if (!nguoiTheoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Trả về 404 Not Found nếu không tìm thấy người theo
        }
        nguoiTheoService.deleteById(id);
        return ResponseEntity.noContent().build(); // Trả về 204 No Content khi xóa thành công
    }

    @GetMapping("/{id}")
    public ResponseEntity<NguoiTheoResponseDTO> getNguoiTheoById(@PathVariable Long id) {
        Optional<NguoiTheo> nguoiTheoOptional = nguoiTheoService.findById(id);
        return nguoiTheoOptional.map(nguoiTheo -> ResponseEntity.ok(new NguoiTheoResponseDTO(nguoiTheo)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Trả về 404 Not Found nếu không tìm thấy người theo
    }

    @GetMapping
    public ResponseEntity<List<NguoiTheoResponseDTO>> getAllNguoiTheo() {
        List<NguoiTheo> nguoiTheoList = nguoiTheoService.findAll();
        if (nguoiTheoList.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 No Content nếu không có người theo
        }
        List<NguoiTheoResponseDTO> responseDTOList = nguoiTheoList.stream()
                .map(NguoiTheoResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOList); // Trả về 200 OK với danh sách người theo
    }

    @GetMapping("/{id}/detail")
    public ResponseEntity<NguoiTheoDetailResponseDTO> getNguoiTheoDetail(@PathVariable Long id) {
        // Tìm kiếm NguoiTheo dựa trên id
        Optional<NguoiTheo> nguoiTheoOptional = nguoiTheoService.findById(id);
        if (!nguoiTheoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Trả về 404 Not Found nếu không tìm thấy NguoiTheo
        }

        NguoiTheo nguoiTheo = nguoiTheoOptional.get();

        // Lấy danh sách TheoXuKhach dựa trên id của NguoiTheo
        List<TheoXuKhach> theoXuKhachList = theoXuKhachService.findAllByIdNguoiTheo(id);

        // Chuyển đổi sang danh sách KhachHangDTO với thông tin số lượng XuTheo
//        List<KhachHangDTO> khachHangDTOList = theoXuKhachList.stream()
//                .map(theoXuKhach -> new KhachHangDTO(theoXuKhach.getKhachHang().getName(), theoXuKhach.getXuTheo(), theoXuKhach.getKhachHang().getLoai().getId(), theoXuKhach.getKhachHang().getId()))
//                .collect(Collectors.toList());
        List<KhachHangDTO> khachHangDTOList = new ArrayList<>();
        for (TheoXuKhach theoXuKhach : theoXuKhachList) {
            KhachHangDTO kh = new KhachHangDTO();
            kh.setName(theoXuKhach.getKhachHang().getName());
            kh.setXuTheo(theoXuKhach.getXuTheo());
            kh.setLoai(theoXuKhach.getKhachHang().getLoai());
            kh.setIdKhach(theoXuKhach.getKhachHang().getId());
            kh.setTinhtien(tinhTienService.findAllTinhTienByKhachHang(theoXuKhach.getKhachHang().getId()));
            khachHangDTOList.add(kh);
        }

        // Tạo đối tượng DTO để trả về thông tin chi tiết NguoiTheo và danh sách KhachHangDTO
        NguoiTheoDetailResponseDTO responseDTO = new NguoiTheoDetailResponseDTO(nguoiTheo, khachHangDTOList);

        return ResponseEntity.ok(responseDTO); // Trả về 200 OK với thông tin chi tiết của NguoiTheo
    }
}

