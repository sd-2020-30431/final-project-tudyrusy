package com.rustudor.presentation.controller;


import com.rustudor.Dto.*;

import com.rustudor.Util.DataValidator;
import com.rustudor.Util.Session;
import com.rustudor.Util.SessionManager;
import com.rustudor.business.mediator.Mediator;
import com.rustudor.business.mediator.comand.AddPlaneCommand;
import com.rustudor.business.mediator.comand.RegisterCommand;
import com.rustudor.business.mediator.handler.*;
import com.rustudor.business.mediator.query.*;
import com.rustudor.business.mediator.response.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private Mediator mediator;


    @GetMapping(value = "/getRole")
    public ResponseEntity<StringObj> getRole(@RequestHeader("token") String token) {
        Session session = SessionManager.getSessionMap().get(token);
        if (session == null)
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(new StringObj(session.getRole()), HttpStatus.OK);
    }

    @GetMapping(value = "/getPlanes")
    public ResponseEntity<List<PlaneDto>> getPlanes() {
        GetPlanesQ c = new GetPlanesQ();
        GetPlanesH h = (GetPlanesH) mediator.<GetPlanesQ, GetPlanesR>getHandler(c);
        GetPlanesR r = h.handle(c);
        return new ResponseEntity<>(r.getPlaneDtos(), HttpStatus.OK);
    }

    @PostMapping(value = "/addPlane")
    public ResponseEntity<StringObj> addPlane(@RequestBody String s) {
        System.out.println(s);
        AddPlaneCommand c = new AddPlaneCommand(s);
        AddPlaneCommandHandler h = (AddPlaneCommandHandler) mediator.<AddPlaneCommand, AddPlaneCommandResponse>getHandler(c);
        AddPlaneCommandResponse r = h.handle(c);
        System.out.println(r.getS());
        if (r.getS().equals("ok"))
            return new ResponseEntity<>(new StringObj("ok"),HttpStatus.OK);
        else {
            return new ResponseEntity<>(new StringObj("error"),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody FullUserDto fullUserDto) {

        System.out.println(fullUserDto);
        if (!DataValidator.validateUser(fullUserDto)) {
            System.out.println("user input error");
            return new ResponseEntity<>("INVALID DATA", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        RegisterCommand c = new RegisterCommand(fullUserDto);
        RegisterCommandHandler h = (RegisterCommandHandler) mediator.<RegisterCommand, RegisterCommandResponse>getHandler(c);
        RegisterCommandResponse r = h.handle(c);
        switch (r.getResponse()) {
            case 0:
                return new ResponseEntity<>("SUCCESS : USER REGISTERED", HttpStatus.OK);
            case -1:
                return new ResponseEntity<>("DUPLICATE", HttpStatus.CONFLICT);
            default:
                return new ResponseEntity<>("UNKNOWN ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<String> logout(@RequestHeader("token") String token) {
        if (!SessionManager.getSessionMap().containsKey(token))
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        else {
            LogoutQuery q = new LogoutQuery(token);
            LogoutQueryHandler h = (LogoutQueryHandler) mediator.<LogoutQuery, LogoutQueryResponse>getHandler(q);
            LogoutQueryResponse r = h.handle(q);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto) {
        LoginQuery loginQuery = new LoginQuery(loginDto);
        LoginQueryHandler loginQueryHandler = (LoginQueryHandler) mediator.<LoginQuery, LoginQueryResponse>getHandler(loginQuery);
        LoginQueryResponse loginQueryResponse = loginQueryHandler.handle(loginQuery);
        TokenDto tokenDto = loginQueryResponse.getTokenDto();
        //System.out.println("ok");
        System.out.println(loginDto.getUsername());
        if (tokenDto != null)
            return new ResponseEntity<>(tokenDto, HttpStatus.OK);
        else
            return new ResponseEntity<>(tokenDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
