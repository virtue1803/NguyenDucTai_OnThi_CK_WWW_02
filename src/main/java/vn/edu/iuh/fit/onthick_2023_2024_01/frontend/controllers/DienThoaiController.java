package vn.edu.iuh.fit.onthick_2023_2024_01.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.onthick_2023_2024_01.backend.models.DienThoai;
import vn.edu.iuh.fit.onthick_2023_2024_01.backend.services.impl.DienThoaiService;

import java.util.List;

@RestController
@RequestMapping("/api/dienthoai")

public class DienThoaiController {
    @Autowired
    private DienThoaiService dienThoaiService;


    @GetMapping
    public List<DienThoai> getAllDienThoai() {
        return dienThoaiService.getAllDienThoai();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DienThoai> getDienThoaiById(@PathVariable Long id) {
        DienThoai dienThoai = dienThoaiService.getDienThoaiById(id);
        return dienThoai != null ? ResponseEntity.ok(dienThoai) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public DienThoai addDienThoai(@RequestBody DienThoai dienThoai) {
        return dienThoaiService.addDienThoai(dienThoai);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DienThoai> updateDienThoai(@PathVariable Long id, @RequestBody DienThoai dienThoai) {
        DienThoai updatedDienThoai = dienThoaiService.updateDienThoai(id, dienThoai);
        return updatedDienThoai != null ? ResponseEntity.ok(updatedDienThoai) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDienThoai(@PathVariable Long id) {
        dienThoaiService.deleteDienThoai(id);
        return ResponseEntity.noContent().build();
    }
}
