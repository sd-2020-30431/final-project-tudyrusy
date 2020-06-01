package com.rustudor.business.Services;

import com.rustudor.Dto.*;
import com.rustudor.Util.Session;
import com.rustudor.Util.SessionManager;
import com.rustudor.business.factory.Report;
import com.rustudor.business.factory.ReportFactory;
import com.rustudor.entity.Login;
import com.rustudor.entity.Plane;
import com.rustudor.entity.User;
import com.rustudor.persistence.repository.LoginRepository;
import com.rustudor.persistence.repository.PlaneRepository;
import com.rustudor.persistence.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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

    public List<PlaneDto> getPlanes() {
        List<PlaneDto> planeDtos = new ArrayList<>();

        List<Plane> planes = planeRepository.findAllByOkEqualsOrOkEquals(0,2);
        for (Plane p : planes) {
            System.out.println(p.getModel());
            if (p.getOk()==0)
                planeDtos.add(new PlaneDto(p.getId(),p.getModel(),"unchecked"));
            else
                planeDtos.add(new PlaneDto(p.getId(),p.getModel(),"problem"));
        }

        return  planeDtos;
    }

    public FullPlaneDto getPlane(int id) {
        Plane plane = planeRepository.findById(id);
        if (plane.getOk()==0)
            return new FullPlaneDto(plane.getId(),plane.getModel(),"unchecked",plane.getLandingGear().getStatus(),plane.getLandingGear().getDescription(),plane.getWings().getStatus(),plane.getWings().getDescription(),plane.getEngine().getStatus(),plane.getEngine().getDescription());
        else
            return new FullPlaneDto(plane.getId(),plane.getModel(),"problem",plane.getLandingGear().getStatus(),plane.getLandingGear().getDescription(),plane.getWings().getStatus(),plane.getWings().getDescription(),plane.getEngine().getStatus(),plane.getEngine().getDescription());
    }

    public List<ReportDto> getReports() {
        List<Plane> planes = planeRepository.findAll();
        List<ReportDto> reportDtos = new ArrayList<>();

        ReportFactory reportFactory = new ReportFactory();
        Report report = reportFactory.getReport("BRIEF");
        Report dreport = reportFactory.getReport("DETAILED");

        for (Plane p : planes){
            reportDtos.add(new ReportDto(p.getId(),p.getModel(),p.getOk(),report.makeReport(p),dreport.makeReport(p)));
        }

        return reportDtos;
    }

    public List<Integer> getPilots() {
        List<Integer> pilotIds = new ArrayList<>();

        List<Login> users = loginRepository.findAllByRoleEquals("PILOT");

        for (Login u:users){
            pilotIds.add(u.getId());
        }

        return pilotIds;
    }

    public int getp(String username) {
        Login login = loginRepository.findByUsername(username);
        return login.getOk();
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
