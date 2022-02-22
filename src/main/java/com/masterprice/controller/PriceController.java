package com.masterprice.controller;

import com.masterprice.domain.request.PriceRequest;
import com.masterprice.domain.response.BaseResponse;
import com.masterprice.entity.Price;
import com.masterprice.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/price")
public class PriceController {
    private final PriceService priceService;

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> savePrice(@Valid @RequestBody PriceRequest request) {
        Price response = priceService.savePrice(request);
        return ResponseEntity.ok(new BaseResponse(HttpStatus.CREATED.toString(), "Save Price Success", response));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getPriceDetail(@PathVariable(name = "id") Integer id) {
        Price response = priceService.getOneByProductId(id);
        return ResponseEntity.ok(new BaseResponse(HttpStatus.OK.toString(), "Price Detail", response));
    }

    @PostMapping(path = {"/add-price"})
    public String addPrice(Model model, PriceRequest request) {
        model.addAttribute("priceRequest", new PriceRequest());
        priceService.savePrice(request);
        return "add-price";
    }

    @GetMapping(path = {"/home"})
    public String index(Model model) {
        model.addAttribute("priceRequest", new PriceRequest());
        return "add-price";
    }
}
