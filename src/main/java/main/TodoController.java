package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.Business;

import java.util.List;

@RestController
public class TodoController {

    @GetMapping("/businesses/")
    public List<Business> list() {
        return Storage.getAllBusinesses();
    }

    @PostMapping("/businesses/")
    public int add(Business business) {
        return Storage.addBusiness(business);
    }

    @GetMapping("/businesses/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Business business = Storage.getBusiness(id);
        if (business == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity(business, HttpStatus.OK);
    }
}
