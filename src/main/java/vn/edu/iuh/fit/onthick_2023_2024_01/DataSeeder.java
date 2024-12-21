//package vn.edu.iuh.fit.onthick_2023_2024_01;
//
//import net.datafaker.Faker;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import vn.edu.iuh.fit.onthick_2023_2024_01.backend.models.DienThoai;
//import vn.edu.iuh.fit.onthick_2023_2024_01.backend.services.impl.DienThoaiService;
//
//@Component
//public class DataSeeder implements CommandLineRunner {
//
//    @Autowired
//    private DienThoaiService dienThoaiService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Sử dụng Faker để tạo dữ liệu giả
//        Faker faker = new Faker();
//
//        for (int i = 0; i < 10; i++) {
//            DienThoai dienThoai = new DienThoai();
//            dienThoai.setTenDienThoai(faker.commerce().productName());
//            dienThoai.setThongTin(faker.lorem().sentence(5));
//            dienThoai.setNhaCungCap(faker.company().name());
//            dienThoai.setDiaChi(faker.address().fullAddress());
//            dienThoai.setGia(Double.parseDouble(faker.commerce().price(100, 1000)));
//
//            // Lưu vào database
//            dienThoaiService.addDienThoai(dienThoai);
//        }
//
//        System.out.println("Đã thêm 10 điện thoại vào database!");
//    }
//}
