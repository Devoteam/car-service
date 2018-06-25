package be.arno.carservice.controllers;

import static com.google.common.collect.Lists.newArrayList;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cars", produces = APPLICATION_JSON_UTF8_VALUE)
public class CarController {

  @GetMapping(value = "/hello")
  public String helloFromCarService() {
    return "Hello from Car-Service";
  }

  @GetMapping(value = "/companies/{companyId}")
  public List<String> getAllCarsForCompany(@PathVariable int companyId) {

    switch (companyId) {
      case 1:
        return newArrayList("BWM1", "AUDI A3", "MERCEDES A");
      case 2:
        return newArrayList("BWM2", "AUDI A4", "MERCEDES B");
      case 3:
        return newArrayList("BWM3", "AUDI A5", "MERCEDES C");
      default:
        return newArrayList("BWM4", "AUDI A6", "MERCEDES S");
    }

  }


}
