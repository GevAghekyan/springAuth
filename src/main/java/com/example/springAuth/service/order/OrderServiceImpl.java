package com.example.springAuth.service.order;

import com.example.springAuth.facade.order.OrderDTO;
import com.example.springAuth.persistance.entities.Order;
import com.example.springAuth.persistance.entities.Person;
import com.example.springAuth.persistance.entities.Product;
import com.example.springAuth.persistance.repos.OrderRepo;
import com.example.springAuth.persistance.repos.PersonRepo;
import com.example.springAuth.persistance.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final PersonRepo personRepo;
    private final ProductRepo productRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, PersonRepo personRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.personRepo = personRepo;
        this.productRepo = productRepo;
    }

    @Override
    public OrderDTO create(OrderDTO dto) {
        Order saved = orderRepo.save(orderFromDTO(dto));
        return dtoFromOrder(saved);
    }

    @Override
    public OrderDTO getById(Long id) {
        Order byId = orderRepo.getById(id);
        return dtoFromOrder(byId);
    }

    @Override
    public ArrayList<OrderDTO> getAll() {
        List<Order> all = orderRepo.findAll();
        List<OrderDTO> collect = all.stream()
                .map(each -> dtoFromOrder(each))
                .collect(Collectors.toList());
        return (ArrayList<OrderDTO>) collect;
    }

    @Override
    public void deleteById(Long id) {
        orderRepo.deleteById(id);
    }

    private Order orderFromDTO(OrderDTO dto) {
        Order order = new Order();
        order.setTrackingNumber(dto.getUuid());
        Long personId = dto.getPersonId();
        ArrayList<Long> productIds = dto.getProductIds();
        Person person = personRepo.getById(personId);
        ArrayList<Product> products = new ArrayList<>();
        productIds.forEach(each -> products.add(productRepo.getById(each)));
        System.out.println(person);
        order.setPerson(person);
        System.out.println(products);
        order.setProducts(products);
        return order;
    }

    public OrderDTO dtoFromOrder(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getId());
        orderDTO.setUuid(order.getTrackingNumber());
        orderDTO.setPersonId(order.getPerson().getId());
        List<Product> products = order.getProducts();
        ArrayList<Long> productIds = new ArrayList<>();
        products.forEach(each -> productIds.add(each.getId()));
        orderDTO.setProductIds(productIds);
        return orderDTO;
    }
}
