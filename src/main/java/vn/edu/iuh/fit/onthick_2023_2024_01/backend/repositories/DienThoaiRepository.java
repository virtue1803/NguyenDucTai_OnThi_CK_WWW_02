package vn.edu.iuh.fit.onthick_2023_2024_01.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.onthick_2023_2024_01.backend.models.DienThoai;
@Repository
public interface DienThoaiRepository extends JpaRepository<DienThoai, Long> {
}