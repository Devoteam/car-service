package be.arno.carservice.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cars", produces = APPLICATION_JSON_UTF8_VALUE)
public class CarController {

  @GetMapping
  public String test() {
    return "Car-Service";
  }

}
