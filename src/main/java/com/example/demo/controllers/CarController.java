package com.example.demo.controllers;

import com.example.demo.model.Car;
import com.example.demo.model.characteristicsAuto.BodyCar;
import com.example.demo.model.characteristicsAuto.Color;
import com.example.demo.model.characteristicsAuto.EngineVolume;
import com.example.demo.model.characteristicsAuto.TypeEngine;
import com.example.demo.repository.CarRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(CarController.class);

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
        model.addAttribute("engineVolumes", EngineVolume.values());
        model.addAttribute("typeEngines", TypeEngine.values());
        model.addAttribute("colors", Color.values());
        model.addAttribute("bodyCars", BodyCar.values());
        model.addAttribute("car", new Car());
        return "Car";
    }

    @GetMapping("/Cars")
    public String allCars(Model model) {
        initCar();
        model.addAttribute("cars", carRepository.findAll());

        return "Cars";
    }

    /**
     * Creates {@link Car}.
     *
     * @param car  - {@link Car} entity to be created
     * @param file - car image
     * @return Cars template
     * @throws IOException on image exception
     */
    @PostMapping("/createCar")
    public String createCar(@ModelAttribute Car car, @RequestParam("file") MultipartFile file) throws IOException {
        byte[] bFile = file.getBytes();
        car.setPhoto(bFile);

        carRepository.save(car);
        logger.info("Car {} is created", car);
        return "redirect:/Cars";
    }

    @GetMapping("/showImage/{id}")
    public void showImage(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");

        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            InputStream is = new ByteArrayInputStream(carOptional.get().getPhoto());
            IOUtils.copy(is, response.getOutputStream());
        } else {
            logger.error("Car with id:{} was not find", id);
        }
    }

    /**
     * Deletes {@link Car} by given id.
     *
     * @param id - search criteria
     * @return Cars template
     */
    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable Integer id) {
        carRepository.deleteById(id);

        logger.info("Car with id:{} is deleted.", id);
        return "redirect:/Cars";
    }

    /**
     * Initializes a car. Just for testing
     */
    private void initCar() {

    }

    @GetMapping("/pageCar/{id}")
    public String pageCar (@PathVariable Integer id, Model model) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()){
            model.addAttribute("car", carOptional.get());
            model.addAttribute("brands", brands);
            model.addAttribute("engineVolumes", EngineVolume.values());
            model.addAttribute("typeEngines", TypeEngine.values());
            model.addAttribute("colors", Color.values());
            model.addAttribute("bodyCars", BodyCar.values());
            logger.info("Car with id:{} is found.", id);
            return "pageCar";
        } else {
            logger.error("404! Car with id:{} not found.", id);
            return  "404";
        }
    }


}

