package com.example.demo.controllers;

import com.example.demo.model.Car;
import com.example.demo.model.characteristicsAuto.Color;
import com.example.demo.model.characteristicsAuto.EngineVolume;
import com.example.demo.repository.CarRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;
    private List<String> brands = new ArrayList<>();

    public CarController() {
        brands.add("BMW");
        brands.add("GAZ");
        brands.add("Volvo");
    }



    @GetMapping("/createCar")
    public String createCar(Model model) {
        model.addAttribute("brands", brands);
        model.addAttribute("colors", Color.values());
        model.addAttribute("engineVolumes", EngineVolume.values());
        model.addAttribute("car", new Car());
        return "Car";
    }

    public void ss() {
        Optional<Car> carOptional  = carRepository.findById(1);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
        } else {
            System.out.println();

        }
    }

    @GetMapping("/Cars")
    public String allCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());

        return "Cars";
    }

    @PostMapping("/createCar")
    public String createCar(@ModelAttribute Car car, @RequestParam("file") MultipartFile file) throws IOException {
        byte[] bFile = file.getBytes();
        car.setPhoto(bFile);

        carRepository.save(car);
        return "redirect:/Cars";
    }

    @GetMapping("/showImage/{id}")
    public void showImage(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");

        Car car = carRepository.findById(id).get();

        InputStream is = new ByteArrayInputStream(car.getPhoto());
        IOUtils.copy(is, response.getOutputStream());
    }

    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable Integer id) {
    carRepository.deleteById(id);
        return "redirect:/Cars";
    }


}

