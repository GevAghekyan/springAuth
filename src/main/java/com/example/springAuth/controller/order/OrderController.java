package com.example.springAuth.controller.order;

import com.example.springAuth.controller.order.models.OrderRequestModel;
import com.example.springAuth.controller.order.models.OrderResponseModel;
import com.example.springAuth.facade.order.OrderFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class OrderController {

    private final OrderFacade orderFacade;

    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @PostMapping("/order")
    public ResponseEntity<OrderResponseModel> create(@RequestBody OrderRequestModel requestModel) {
        OrderResponseModel saved = orderFacade.create(requestModel);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderResponseModel> getById(@PathVariable Long id) {
        OrderResponseModel byId = orderFacade.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping("/orders")
    public ResponseEntity<ArrayList<OrderResponseModel>> getAll() {
        ArrayList<OrderResponseModel> responseModels = orderFacade.getAll();
        return ResponseEntity.ok(responseModels);
    }

    @DeleteMapping("/order/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        orderFacade.deleteById(id);
    }
}
