package com.example.springbootservicefegin.controller;

import com.example.springbootservicefegin.service.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @创建人 dc
 * @创建时间 2019/4/29
 * @描述
 */
@RestController
public class GameController {

    @Autowired
    IGameService iGameService;


    @RequestMapping("/getGameTest")
    public String getGameTest() {
        String gameTest = iGameService.getGameTest();
        return gameTest+"windows";
    }
}
