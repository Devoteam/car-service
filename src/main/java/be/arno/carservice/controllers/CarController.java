package be.arno.carservice.controllers;

import static com.google.common.collect.Lists.newArrayList;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import be.arno.carservice.models.Car;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cars", produces = APPLICATION_JSON_UTF8_VALUE)
public class CarController {

  private final String BWM = "BMW";
  private final String AUDI = "Audi";
  private final String MERCEDES = "Mercedes";

  private final List<Car> carList = newArrayList(
      // Belfius
      new Car(1, BWM, "BMW 1"),
      new Car(2, AUDI, "Audi A3"),
      new Car(3, MERCEDES, "Mercedes A"),
      // KBC
      new Car(4, BWM, "BMW 2"),
      new Car(5, AUDI, "Audi A4"),
      new Car(6, MERCEDES, "Mercedes B"),
      // ING
      new Car(7, BWM, "BMW 3"),
      new Car(8, AUDI, "Audi A5"),
      new Car(9, MERCEDES, "Mercedes C"),
      // Argenta
      new Car(10, BWM, "BMW 4"),
      new Car(11, AUDI, "Audi A6"),
      new Car(12, MERCEDES, "Mercedes S")
  );

  @GetMapping(value = "/company/{companyId}")
  public List<Car> getAllCarsForCompany(@PathVariable int companyId) {

    switch (companyId) {
      case 1:
        return carList.subList(0, 3);
      case 2:
        return carList.subList(3, 6);
      case 3:
        return carList.subList(6, 9);
      default:
        return carList.subList(9, 12);
    }
  }

  @GetMapping(value = "/details/{carId}")
  public Car getCarById(@PathVariable int carId) {
    return carList.stream().filter(car -> car.getId() == carId).findFirst().get();
  }

}
