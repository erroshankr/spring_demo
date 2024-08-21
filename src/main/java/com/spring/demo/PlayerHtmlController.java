package com.spring.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

 /*   @PostMapping("/editPlayer") // localhost:8080/editPlayer/1
    public String editPlayer(Model model, PlayerModel player){
        //PlayerModel playerModel = playerModelList.get(player.getPlayerID()-1);
        playerModelList.set(player.getPlayerID()-1, player);
        model.addAttribute("player", player);
        model.addAttribute("players", playerModelList);
        return "player_details";
    }*/

    @GetMapping("/edit/{playerID}")
    public String editPlayerByID(Model model,@PathVariable int playerID){

        PlayerModel playerModel = playerModelList.get(playerID-1);
        model.addAttribute("player", playerModel);
        model.addAttribute("players", playerModelList);
        return "player_details";
    }

    @PostMapping("/editPlayer")
    public String updatePlayer(Model model, PlayerModel playerModel){
        playerModelList.set(playerModel.getPlayerID()-1, playerModel);

        model.addAttribute("player", new PlayerModel());
        model.addAttribute("players", playerModelList);
        return "player_details";
    }

    @GetMapping("/deletePlayer/{playerID}")
    public String deletePlayer(Model model, @PathVariable int playerID){
   //     playerModelList.remove(playerID - 1);
        playerModelList.remove(playerModelList.get(playerID-1));
        model.addAttribute("player", new PlayerModel());
        model.addAttribute("players", playerModelList);
        return "player_details";
    }

}

// CRUD --> CREATE--> (POST), READ(GET), UPDATE(PUT/POST), DELETE(DELETE)
// UI --> URL hit --> corresponding method in Controller is called --> logic execute --> return html page name
// variables in html page must be passed from backend service to html

// Create player Flow
// UI load --> form --> mapped to player object --> data filled in form wil be bound to player object
// on hitting submit(POST) button--> player object mapped to form will be submitted as parameter to controller API
// player object will be stored in backend and new html page will be returned

// Update player
/*
1. On clicking edit icon, corresponding row details should come up in form above for editing
2. Edit the details of the pre-filled form
3. After editing, on clicking submit button, player object mapped with edited form will be sent to backend api in controller.
4. Update the player details received in the storage.
5. Return a new html page
 */

// Remove Player
/*
1. on clicking delete icon of a row, that playerID must be sent to backend api controller
2. remove that entry base don playerID from the storage and load html
 */