package com.maria.ass1.business.controller;

import com.maria.ass1.dao.CustomerDAO;
import com.maria.ass1.dao.ProdusDAO;
import com.maria.ass1.model.products.Product;
import com.maria.ass1.model.products.Type;
import com.maria.ass1.model.user.Customer;
import com.maria.ass1.repository.ProdusRepoditory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/items")
public class ItemController {
    @Autowired
    private ProdusDAO produsDAO;
    @Autowired
    private CustomerDAO userDao;
    private final ProdusRepoditory itemService;
    public ItemController(ProdusRepoditory itemService){
        super();
        this.itemService=itemService;
    }
    @PostMapping
    public ResponseEntity<?> saveItem(@RequestBody @Valid Product itemDto){
        try{
            return new ResponseEntity<>(itemService.save(itemDto), HttpStatus.CREATED);}
        catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Name is already used", HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping
    public List<Product> getAllItems()
    {
        return itemService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getItemById(@PathVariable("id") Long itemId){
        return new ResponseEntity<>(itemService.getReferenceById(itemId), HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<Product> updateItem(@RequestBody Product itemDto){
        return new ResponseEntity<>(itemService.saveAndFlush(itemDto), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Long id){
        //delete item from database
        itemService.delete(new Product(id));
        return new ResponseEntity<>("Item deleted successfully.", HttpStatus.OK);
    }
    @GetMapping("size/{type}/{size}")
    public List<Product>filterSize(@PathVariable("type") Type type, @PathVariable("size") Integer size){
        List<Product> items= itemService.findAll();
        items=produsDAO.findBySize( items.get(0).getSize());
        return (List<Product>) itemService.findAll(Pageable.ofSize(size));
    }
    @GetMapping("material/{type}/{material}")
    public List<Product>filterMaterial(@PathVariable("type") Type type, @PathVariable("material") String material){
        List<Product> items= itemService.findAll();
        items=produsDAO.findByPrice((float) items.get(0).getPrice());
        items=produsDAO.findByType((items.get(0).getType()).toString());
        return itemService.findAll(material);
    }
    @GetMapping("/createReport")
    public ResponseEntity<String> createReport(){
        itemService.createReport();
        return new ResponseEntity<>("Report created succsesfuly",HttpStatus.OK);
    }

    @RequestMapping(value = "list/{userId}", method = RequestMethod.GET)
    public String listProduse(Product model, @PathVariable int userId){
        Customer user = null;
        Optional<Customer> optionalUser = userDao.findById(userId);
        if(optionalUser.isPresent()) {

            user = (Customer) optionalUser.get();
        }
        List <Customer> addUsers=null;

        if(produsDAO.findByCantity(model.getAvailability())){
            if(produsDAO.findByName(model.getName())){
                if(produsDAO.findByMaterial(model.getMaterial())){

                    addUsers.add(new Customer());
                }
            }
        }
        return  produsDAO.findAll().toString();
    }


}
