package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.CarService;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCars(ModelMap modelMap) {
        if (CarService.getInstance().getCarList() == null)
            modelMap.addAttribute("car", "car quantity is not enough");
        else
            modelMap.addAttribute("car", CarService.getInstance().getCarList());
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
