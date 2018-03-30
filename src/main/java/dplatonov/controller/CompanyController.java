package dplatonov.controller;

import dplatonov.model.Company;
import dplatonov.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

  private final CompanyService service;

  @Autowired
  public CompanyController(CompanyService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<?> getCompanies() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<?> saveCompany(@RequestBody Company company) {
    return new ResponseEntity<>(service.save(company), HttpStatus.OK);
  }

  @DeleteMapping
  public ResponseEntity<?> deleteCompany(@PathVariable("id") Long id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
