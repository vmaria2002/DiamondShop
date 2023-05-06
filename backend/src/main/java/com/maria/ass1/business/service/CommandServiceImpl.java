package com.maria.ass1.business.service;


import com.maria.ass1.exception.ResourceNotFoundException;
import com.maria.ass1.model.order.Order;
import com.maria.ass1.model.products.Product;
import com.maria.ass1.model.user.Customer;
import com.maria.ass1.repository.CustomerRepository;
import com.maria.ass1.repository.OrderRepository;
import com.maria.ass1.repository.ProdusRepoditory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.*;

@Service
public class CommandServiceImpl extends Observable implements CommandService {
    private final OrderRepository commandRepository;
    private final CustomerRepository customerRepository;
    private final ProdusRepoditory itemRepository;
    private final OrderRepository orderItemRepository;
    private final AdminServiceImpl adminServiceImpl;

    public CommandServiceImpl(OrderRepository commandRepository, CustomerRepository customerRepository, ProdusRepoditory itemRepository, OrderRepository orderItemRepository, AdminServiceImpl adminServiceImpl) {
        this.commandRepository = commandRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.orderItemRepository = orderItemRepository;
        this.adminServiceImpl = adminServiceImpl;
    }


    @Override
    public Order saveCommand(Long idItem, Long idCustomer) {
        //obtin item-ul si customer-ul pentru a le salva pentru comanda
        Optional<Product> item = itemRepository.findById(idItem);
        Optional<Customer> customer = customerRepository.findById(idCustomer);
        Order command;
        boolean ok = true;
        //caut ultima comanda ca sa verfic daca a fost deja creata comanda pentru clientul cu idCustomer si doar adaug produse la comanda
        command = commandRepository.findFirstByOrderByIdDesc();
        if (command != null) {
            //daca exista comanda gasita verific daca data comenzii este aceeasi cu data de azi si daca id-ul clientului este acelasi cu id-clientului curent
            if(!command.getStatus().equals("processed")){
                if (customer.get().getId().equals(command.getClient().getId()) && command.getDate().isEqual(LocalDate.now())) {
                    List<Product> myList = orderItemRepository.findByIdOrderId(command.getIdOrder());
                    //verific daca exista deja produsul in comanda si cresc cantitatea
                    for (Product itemOrder : myList) {

                        OrderRepository orderItemRepository1 = orderItemRepository;

                    }
                    //daca nu exista il crez si il adaug la comanda

                } else {
                    command = null;
                }
            }else{
                command=null;
            }

        }
        //daca nu exista comanda pentru client adaug comanda noua
        if (command == null) {
            command = new Order();
            command.setDate(LocalDate.now());
            command.setClient(customer.get());
            command.setStatus("new");
            commandRepository.save(command);
            command = commandRepository.findFirstByOrderByIdDesc();
        }
        return command;

    }

    @Override
    public List<Order> getAllCommands() {
        return commandRepository.findAll();
    }

    @Override
    public Order getCommandById(Long id) {
        return commandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Command", "Id", id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Order updateCommand(Order command) {
        Order existingCommand = commandRepository.findById(command.getIdOrder()).orElseThrow(() -> new ResourceNotFoundException("Command", "Id", command.getIdOrder(), HttpStatus.NOT_FOUND));
        if (command.getClient() != null) {
            existingCommand.setClient(command.getClient());
        }
        if (command.getStatus() != null) {
            existingCommand.setStatus(command.getStatus());
        }
        if (command.getDate() != null) {
            existingCommand.setDate(command.getDate());
        }
        commandRepository.save(existingCommand);
        return existingCommand;
    }

    @Override

    public void deleteCommand(Long id) {
        commandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Command", "Id", id, HttpStatus.NOT_FOUND));
        List<Product> orderItemList = orderItemRepository.findByIdOrderId(id);
        System.out.println(id);
        for (Product o : orderItemList) {
            orderItemRepository.deleteById(o);
        }
        commandRepository.deleteById(id);
    }

    @Override
    public void decreaseCantity(Long idCommand, Long idItem) {
        Order command = commandRepository.findById(idCommand).get();
        List<Product> myList = orderItemRepository.findByIdOrderId(command.getIdOrder());
        int size = myList.size();
        for (Product itemOrder : myList) {

                if (itemOrder.getCantity() > 1) {
                    itemOrder.setCantity(itemOrder.getCantity() - 1);
                    orderItemRepository.save(command);
                } else {

                    if (size == 1) {
                        commandRepository.deleteById(idCommand);
                    }
                }
            }
        }


    @Override
    public double calculatePrice(Long id) {
        Order command = commandRepository.findById(id).get();
        double price = 0.0;
        Product item = null;
        List<Product> myList = orderItemRepository.findByIdOrderId(command.getIdOrder());
        for (Product itemOrder : myList) {
            price+=item.getPrice()*itemOrder.getCantity();
        }
        command.setTotal(price);
        commandRepository.save(command);
        return price;
    }

    @Override
    public List<Product> getItemsCommand(Long id,List<Integer>cantity) {
        List<Product> items=new ArrayList<>();
        Long idItem;
        List<Product> orderItemList = orderItemRepository.findByIdOrderId(id);
        for (Product o : orderItemList) {
            idItem=(o.getIdItem());
            items.add(itemRepository.findById(idItem).get());
            cantity.add(o.getCantity());
        }
        return  items;
    }

    @Override
    public List<Product> getCommandItems(Long id) {
        List<Product> items=new ArrayList<>();
        Long idItem;
        List<Product> orderItemList = orderItemRepository.findByIdOrderId(id);
        for (Product o : orderItemList) {
            idItem=(o.getIdItem());
            items.add(itemRepository.findById(idItem).get());
        }
        Collections.sort(items);
        return  items;
    }
    @Override
    public int numberOfAppearances(Long id) {
        List<Product>orderItemList=orderItemRepository.findOrderItemByItem(itemRepository.findById(id).get());
        return orderItemList.size();
    }

    @Override
    public String finishCommand(Long id) {
        Order command=commandRepository.findById(id).get();
        calculatePrice(id);
        List<Integer>cantity=new ArrayList<>();
        List<Product>items=getItemsCommand(id,cantity);
        String s="";
        Customer customer=command.getClient();
        s=s+"Comanda "+ command.getIdCustomer()+", Data: "+command.getDate()+"\n";
        s=s+"Nume client: "+ customer.getName()+" "+"\n";
        s=s+"Telefon: "+customer.getPhone()+"\n";
        s=s+"Adresa:\n";
        s=s+"         Tara: "+customer.getCountry()+"\n";
        s=s+"         Oras: "+customer.getCity()+"\n";
        s=s+"         Strada: "+customer.getStreet()+" "+customer.getNumber()+"\n";
        s=s+"         Total comanda: "+command.getTotal()+"\n";
        s=s+"Lista produse:\n";
        for(int i=0;i<items.size();i++){
            s=s+"         "+items.get(i).getName()+" x"+cantity.get(i)+"\n";

        }
        String s1="";
        s1=s1+customer.getUsername()+" "+customer.getName()+ "/"+customer.getEmail();
        String[] string= {s,s1};
        command.setStatus("processed");
        commandRepository.save(command);
        setChanged();
        notifyObservers(string);
        return s;
    }



    public void changed(Long id){
       this.addObserver(adminServiceImpl);
       String s=finishCommand(id);

    }

    @Override
    public List<Integer> getCantity(Long id) {
        List<Integer>cantity =new ArrayList<>();
        List<Product> orderItemList = orderItemRepository.findByIdOrderId(id);
        List<Product>items=getCommandItems(id);
        for (int i=0;i<items.size();i++) {
            for(int j=0;j<orderItemList.size();j++){
                if(orderItemList.get(j).getIdItem()==items.get(i).getIdItem()){
                    cantity.add(orderItemList.get(j).getCantity());
                }
            }

        }

        return cantity;
    }

    @Override
    public List<String> itemsInADay(int month, int day, int year) {
        LocalDate ld=LocalDate.of(year,month,day);
        List<Order>commands=new ArrayList<>();
        Set<Product>items=new HashSet<>();
        List<String>result=new ArrayList<>();
        for(Order command:commandRepository.findAll()){
            if(command.getDate().equals(ld)){
                commands.add(command);
            }
        }
        System.out.println(commands.size());
        for(Order command:commands) {
            for(Product item:getCommandItems(command.getIdOrder())){
                items.add(item);
            }
        }
        for(Product item:items){
            String s=item.getName()+"/"+numberOfAppearances(item.getIdItem());
            result.add(s);
        }
            return result;
    }

    @Override
    public void createReportItem(int month, int day, int year) {
        List<String>items=itemsInADay(month,day,year);
        String nameFile="./"+LocalDate.of(year,month,day).toString()+".txt";
        CommandServiceImpl CsvReport = null;

    }


}

