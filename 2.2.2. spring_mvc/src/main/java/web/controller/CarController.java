package web.controller;

import model.Car;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.CarService;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCars(ModelMap modelMap, @RequestParam(value = "locale") @Nullable String locale) {

        if (CarService.getInstance().getCarList() == null) {
            modelMap.addAttribute("car", "car quantity is not enough");
        } else
            modelMap.addAttribute("car", CarService.getInstance().getCarList());
        if (locale != null) {
            if (locale.equals("en")) modelMap.addAttribute("title", "CARS");
            else if (locale.equals("ru")) modelMap.addAttribute("title", "МАШИНЫ");
        }
        return "cars";
    }

    @GetMapping(value = "/addCar")
    public String addCar(ModelMap modelMap) {
        Car car = new Car();
        modelMap.addAttribute("car", car);
        return "addCar";
    }

    @PostMapping(value = "/saveCar")
    public String saveCar(@ModelAttribute("car") Car car) {
        CarService.getInstance().addCar(car);
        return "redirect:/cars";
    }
}
