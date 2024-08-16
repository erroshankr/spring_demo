package com.spring.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller  // always returns html view name  --> /resource/templates/filename.html --> beautification
public class PlayerHtmlController {
    List<PlayerModel> playerModelList = new ArrayList<>();

    @GetMapping("/")
    public String getAllInfo(Model model){  // API -> Application Programming Interface
        try {
            model.addAttribute("players", playerModelList); // sends data from backend to frontend
            model.addAttribute("player", new PlayerModel());
            return "player_details"; // /resource/templates/player_details.html
        }catch (Exception e){
            return "FAILURE";
        }
    }

    @PostMapping("/addPlayer")
    public String createInfo(Model model, PlayerModel player){
        System.out.println(player.getName() + " - " + player.getJerseyNo());
        player.setPlayerID(playerModelList.size() + 1);
        playerModelList.add(player);
        model.addAttribute("players", playerModelList); // sends data from backend to frontend
        model.addAttribute("player", new PlayerModel());
        return "player_details";
    }

    @GetMapping("/editPlayer/{playerID}") // localhost:8080/editPlayer/1
    public String editPlayer(Model model, @PathVariable int playerID){
        PlayerModel playerModel = playerModelList.get(playerID-1);
        model.addAttribute("player", playerModel);
        model.addAttribute("players", playerModelList);
        return "player_details";
    }
}

// CRUD --> CREATE--> (POST), READ(GET), UPDATE(PUT/POST), DELETE(DELETE)
