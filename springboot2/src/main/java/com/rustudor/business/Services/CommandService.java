package com.rustudor.business.Services;

import com.rustudor.Dto.FullPlaneDto;
import com.rustudor.Dto.FullUserDto;
import com.rustudor.Dto.PlaneDto1;
import com.rustudor.entity.*;
import com.rustudor.persistence.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommandService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    PlaneRepository planeRepository;

    @Autowired
    EngineRepository engineRepository;
    @Autowired
    WingsRepository wingsRepository;
    @Autowired
    LandingGearRepository landingGearRepository;

    @Transactional
    public int register(FullUserDto fullUserDto) {
        User user = new User();
        Login login = new Login();

        Login login2 = loginRepository.findByUsername(fullUserDto.getUsername());
        if (login2 != null)
            return -1;//duplicate username
        user.setName(fullUserDto.getName());
        login.setRole(fullUserDto.getRole());
        login.setOk(0);
        login.setUsername(fullUserDto.getUsername());
        login.setUserFK(user);
        login.setPassword(fullUserDto.getPassword());
        user.setLogin(login);

        loginRepository.save(login);
        usersRepository.save(user);
        return 0;
    }

    @Transactional
    public String addPlane(PlaneDto1 planeDto1) {
        Plane plane = new Plane();

        Engine engine = new Engine();
        engine.setDescription("");
        engine.setStatus(0);


        Wings wings = new Wings();
        wings.setDescription("");
        wings.setStatus(0);


        LandingGear landingGear = new LandingGear();
        landingGear.setDescription("");
        landingGear.setStatus(0);


        plane.setModel(planeDto1.getModel());
        plane.setPilotId(planeDto1.getPilotId());
        plane.setEngine(engine);
        plane.setLandingGear(landingGear);
        plane.setWings(wings);
        plane.setOk(0);
        /*landingGear.setPlane(plane);
        wings.setPlane(plane);
        engine.setPlane(plane);*/
        engineRepository.save(engine);
        wingsRepository.save(wings);
        landingGearRepository.save(landingGear);
        planeRepository.save(plane);

        return "ok";
    }

    @Transactional
    public void savePlane(FullPlaneDto fullPlaneDto) {
        Plane plane = planeRepository.findById(fullPlaneDto.getId());

        plane.getEngine().setStatus(fullPlaneDto.getEs());
        plane.getEngine().setDescription(fullPlaneDto.getEd());

        plane.getWings().setStatus(fullPlaneDto.getWs());
        plane.getWings().setDescription(fullPlaneDto.getWd());

        plane.getLandingGear().setStatus(fullPlaneDto.getLgs());
        plane.getLandingGear().setDescription(fullPlaneDto.getLgd());

        if (plane.getWings().getStatus() == 1 && plane.getLandingGear().getStatus() == 1 && plane.getEngine().getStatus() == 1)
            plane.setOk(1);
        else plane.setOk(2);

        planeRepository.save(plane);
    }
    @Transactional
    public void pnok(int id) {
        Plane plane = planeRepository.findById(id);
        Login login = loginRepository.findById(plane.getPilotId());
        login.setOk(2);
    }
    @Transactional
    public void pok(int id) {
        Plane plane = planeRepository.findById(id);
        Login login = loginRepository.findById(plane.getPilotId());
        login.setOk(1);
    }

    /*@Transactional
    public void addItem(ItemDto itemDto, Session session) {
        Item i = new Item();
        User user = usersRepository.findByUsername(session.getUsername());

        i.setName(itemDto.getName());
        i.setCalories(itemDto.getCalories());
        i.setExpirationDate(itemDto.getExpirationDate());
        i.setPurchaseDate(itemDto.getPurchaseDate());
        i.setQuantity(itemDto.getQuantity());
        i.setUserFK(user);

        user.getGroceryList().add(i);
        itemRepository.save(i);
    }
    @Transactional
    public void setConsumption(ConsumptionDto consumptionDto, Session session) {
        User user = usersRepository.findByUsername(session.getUsername());
        Item i = itemRepository.findByNameAndUserFK(consumptionDto.getName(), user);
        //System.out.println(i.toString());
        //System.out.println(i.days());
        i.setConsumptionDate(consumptionDto.getConsumptionDate());
        //itemRepository.save(i);
    }
    @Transactional
    public void setGoal(int goal, Session session) {
        User user = usersRepository.findByUsername(session.getUsername());
        user.setGoal(goal);
    }*/

}
