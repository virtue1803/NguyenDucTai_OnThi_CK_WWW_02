package vn.edu.iuh.fit.onthick_2023_2024_01.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.iuh.fit.onthick_2023_2024_01.backend.models.DienThoai;
import vn.edu.iuh.fit.onthick_2023_2024_01.backend.services.impl.DienThoaiService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DienThoaiViewController {

    @Autowired
    private DienThoaiService dienThoaiService;

    @GetMapping("/dienthoai")
    public String getDienThoaiPage(Model model) {
        model.addAttribute("dienThoais", dienThoaiService.getAllDienThoai());
        return "dienthoai/dienthoai";
    }
}
