package com.maria.ass1.business.controller;
import com.maria.ass1.business.service.CustomerService;
import com.maria.ass1.model.user.User;
import com.maria.ass1.raport.Report;
import com.maria.ass1.raport.ReportFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(path = "/api/raport")
public class RaportController {
    static  int nr=1;
    private final CustomerService userService;

    public RaportController(CustomerService userService) {
        this.userService = userService;
    }
    @GetMapping(path = "/txt/{id}")
    public User getTxt(@PathVariable Long id) throws Throwable {
        User myUser= userService.getUser(id);
        System.out.println(myUser.toString());
        Report txtReport = ReportFactory.createReport(ReportFactory.ReportType.TXT, myUser, "Raport"+nr );
        nr++;
        txtReport.generateReport();
        return myUser;
    }
    @GetMapping(path = "/json/{id}")
    public User getJSON(@PathVariable Long id) throws Throwable {
        User myUser= userService.getUser(id);
        Report jsonReport = ReportFactory.createReport(ReportFactory.ReportType.JSON, myUser, "Raport"+nr );
        jsonReport.generateReport();
        return myUser;
    }
}
