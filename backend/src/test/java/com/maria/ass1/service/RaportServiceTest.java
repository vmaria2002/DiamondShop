package com.maria.ass1.service;
import com.maria.ass1.business.service.CustomerService;
import com.maria.ass1.model.user.User;
import com.maria.ass1.raport.Report;
import com.maria.ass1.raport.ReportFactory;
import com.maria.ass1.repository.UserRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.mockito.Mockito.verify;

public class RaportServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private CustomerService userService;
    @Test
  public void createTXT() {
        Long id=2467L;
        try {
                User myUser = userService.getUser(id);
                Report txtReport = ReportFactory.createReport(ReportFactory.ReportType.TXT, myUser, "Raport" + 10);
            }catch(Exception e){

        }
    }
    @Test
    public void createJSON() {
        Long id=2467L;
        try {
            User myUser = userService.getUser(id);
            Report jsonReport = ReportFactory.createReport(ReportFactory.ReportType.JSON, myUser, "Raport" + 10);
        }catch(Exception e){

        }
    }
}
