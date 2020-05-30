package com.rustudor.business.Services;

import com.rustudor.Dto.*;
import com.rustudor.Util.Session;
import com.rustudor.Util.SessionManager;
import com.rustudor.entity.Login;
import com.rustudor.persistence.repository.LoginRepository;
import com.rustudor.persistence.repository.PlaneRepository;
import com.rustudor.persistence.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
public class QueryService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    PlaneRepository planeRepository;

    public TokenDto login(LoginDto loginDto) {
        Login login = loginRepository.findByUsername(loginDto.getUsername());
        if (login != null) {
            if (login.getPassword().equals(loginDto.getPassword())) {
                //SUCCESS
                Session session = new Session(loginDto.getUsername(), Instant.now(), Session.EXPIRATION_TIME, login.getRole());
                String token = SessionManager.add(session);
                return new TokenDto(token, "TOKEN OK");
            } else {
                return null;
            }
        } else {
            //ERROR
            return null;
        }
    }

    public void logout(String token) {
        SessionManager.getSessionMap().remove(token);
    }
    /*
    public ArrayList<ItemDto1> getItems(Session session) {
        ArrayList<ItemDto1> itemDtos = new ArrayList<>();

        User user = usersRepository.findByUsername(session.getUsername());
        for (Item a : user.getGroceryList()) {
            if (a.getConsumptionDate()==null)
                itemDtos.add(new ItemDto1(a.getId(),a.getName(),a.getQuantity(),a.getCalories(),a.getPurchaseDate(),
                        a.getExpirationDate(),"N/As",a.getPerDay()));
            else
                itemDtos.add(new ItemDto1(a.getId(),a.getName(),a.getQuantity(),a.getCalories(),a.getPurchaseDate(),
                        a.getExpirationDate(),a.getConsumptionDate().toString(),a.getPerDay()));
        }
        return itemDtos;
    }
    public StringObj getWeeklyReport(Session session) {
        User user = usersRepository.findByUsername(session.getUsername());
        AbstractFactory weeklyFactory = FactoryProducer.getFactory("WEEKLY");
        Report report = weeklyFactory.getReport("WEEKLY");
        report = new WasteReportDecorator(report);
        StringObj stringObj = new StringObj();
        stringObj.setMyString(report.makeReport(user).getReport());

        return stringObj;
    }

    public StringObj getMonthlyReport(Session session) {
        User user = usersRepository.findByUsername(session.getUsername());
        StringObj stringObj = new StringObj();
        AbstractFactory monthlyFactory = FactoryProducer.getFactory("MONTHLY");
        Report report1 = new WasteReportDecorator(monthlyFactory.getReport("MONTHLY"));
        stringObj.setMyString(report1.makeReport(user).getReport());

        return stringObj;
    }*/
}
