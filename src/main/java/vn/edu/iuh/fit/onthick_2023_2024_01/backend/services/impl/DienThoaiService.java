package vn.edu.iuh.fit.onthick_2023_2024_01.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.onthick_2023_2024_01.backend.models.DienThoai;
import vn.edu.iuh.fit.onthick_2023_2024_01.backend.repositories.DienThoaiRepository;
import vn.edu.iuh.fit.onthick_2023_2024_01.backend.services.IService;

import java.util.ArrayList;
import java.util.List;
@Service
public class DienThoaiService implements IService {

    @Autowired
    private DienThoaiRepository dienThoaiRepository;
    @Override
    public List<DienThoai> getAllDienThoai() {
        List<DienThoai> dienThoais = dienThoaiRepository.findAll();
        return dienThoais != null ? dienThoais : new ArrayList<>();
    }

    @Override
    public DienThoai getDienThoaiById(Long id) {
        return dienThoaiRepository.findById(id).orElse(null);
    }

    @Override
    public DienThoai addDienThoai(DienThoai dienThoai) {
        return dienThoaiRepository.save(dienThoai);
    }

    @Override
    public DienThoai updateDienThoai(Long id, DienThoai dienThoai) {
        DienThoai existingDienThoai = getDienThoaiById(id);
        if (existingDienThoai != null) {
            existingDienThoai.setTenDienThoai(dienThoai.getTenDienThoai());
            existingDienThoai.setThongTin(dienThoai.getThongTin());
            existingDienThoai.setNhaCungCap(dienThoai.getNhaCungCap());
            existingDienThoai.setDiaChi(dienThoai.getDiaChi());
            existingDienThoai.setGia(dienThoai.getGia());
            return dienThoaiRepository.save(existingDienThoai);
        }
        return null;
    }

    @Override
    public void deleteDienThoai(Long id) {
        dienThoaiRepository.deleteById(id);
    }
}
