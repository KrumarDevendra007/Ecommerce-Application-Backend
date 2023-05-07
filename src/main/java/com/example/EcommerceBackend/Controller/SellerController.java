package com.example.EcommerceBackend.Controller;

import com.example.EcommerceBackend.DTO.RequestDTO.SellerRequestDto;
import com.example.EcommerceBackend.DTO.ResponceDTO.SellerResponseDto;
import com.example.EcommerceBackend.Entity.Seller;
import com.example.EcommerceBackend.Exception.EmailAlreadyPresentException;
import com.example.EcommerceBackend.Exception.InvalidSellerException;
import com.example.EcommerceBackend.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public ResponseEntity addSeller(@RequestBody SellerRequestDto sellerRequestDto){

        try {
            SellerResponseDto sellerResponseDto = sellerService.addSeller(sellerRequestDto);
            return new ResponseEntity(sellerResponseDto, HttpStatus.CREATED);
        }
        catch (Exception e) {
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    // GET a seller by email
    @GetMapping("/getByEmailId")
    public ResponseEntity getByEmailId(@RequestParam("emailId") String emailId) throws InvalidSellerException {
             try {
                 SellerResponseDto sellerResponseDto = sellerService.getSellerByEmailId(emailId);
                 return new ResponseEntity(sellerResponseDto, HttpStatus.CREATED);
             }
             catch (Exception e){
                 return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
             }

    }

    // get by id
    @GetMapping("/getById")
    public ResponseEntity getById(@RequestParam("id")Integer id) throws InvalidSellerException {

        try {
            SellerResponseDto sellerResponseDto = sellerService.getSellerById(id);
            return new ResponseEntity(sellerResponseDto, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    // get all seller
    @GetMapping("/getAllSeller")
    public List<SellerResponseDto> getAllSeller(){
        return sellerService.getAllSeller();
    }

    // update seller info based on email id

    // delete a seller based on email

    //delete by id

    // get all sellers of a particular age
}
