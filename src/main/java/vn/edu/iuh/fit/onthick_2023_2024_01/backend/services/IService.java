package vn.edu.iuh.fit.onthick_2023_2024_01.backend.services;

import vn.edu.iuh.fit.onthick_2023_2024_01.backend.models.DienThoai;

import java.util.List;

public interface IService {
    List<DienThoai> getAllDienThoai();
    DienThoai getDienThoaiById(Long id);
    DienThoai addDienThoai(DienThoai dienThoai);
    DienThoai updateDienThoai(Long id, DienThoai dienThoai);
    void deleteDienThoai(Long id);
}
