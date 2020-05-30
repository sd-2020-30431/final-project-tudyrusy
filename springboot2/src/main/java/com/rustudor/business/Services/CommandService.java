package com.rustudor.business.Services;

import com.rustudor.Dto.FullUserDto;
import com.rustudor.entity.Login;
import com.rustudor.entity.Role;
import com.rustudor.entity.User;
import com.rustudor.persistence.repository.LoginRepository;
import com.rustudor.persistence.repository.PlaneRepository;
import com.rustudor.persistence.repository.UsersRepository;
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

    @Transactional
    public int register(FullUserDto fullUserDto) {
        User user = new User();
        Login login = new Login();

        Login login2 = loginRepository.findByUsername(fullUserDto.getUsername());
        if (login2 != null)
            return -1;//duplicate username
        user.setName(fullUserDto.getName());
        login.setRole(fullUserDto.getRole());
        login.setUsername(fullUserDto.getUsername());
        login.setUserFK(user);
        login.setPassword(fullUserDto.getPassword());
        user.setLogin(login);

        loginRepository.save(login);
        usersRepository.save(user);
        return 0;
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
