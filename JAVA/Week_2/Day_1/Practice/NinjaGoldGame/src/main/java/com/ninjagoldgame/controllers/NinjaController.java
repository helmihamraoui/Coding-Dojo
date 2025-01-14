package com.ninjagoldgame.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaController {

    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
            session.setAttribute("earns", new ArrayList<String>());
            session.setAttribute("lose", new ArrayList<String>());
        }
        return "index.jsp";
    }

    @PostMapping("/form")
    public String form(@RequestParam(value = "name") String name, HttpSession session, RedirectAttributes flash) {
        Random random = new Random();
        ArrayList<String> earns = (ArrayList<String>) session.getAttribute("earns");
        ArrayList<String> lose = (ArrayList<String>) session.getAttribute("lose");
        Date date = new Date();

        int gold = (int) session.getAttribute("gold");
        String message;

        switch (name) {
            case "farm":
                int farmGold = random.nextInt(11) + 10; // 10 to 20
                gold += farmGold;
                message = "You entered a farm and earned " + farmGold + " gold. (" + date.toString() + ")";
                earns.add(message);
                break;

            case "cave":
                int caveGold = random.nextInt(6) + 5; // 5 to 10
                gold += caveGold;
                message = "You entered a cave and earned " + caveGold + " gold. (" + date.toString() + ")";
                earns.add(message);
                break;

            case "house":
                int houseGold = random.nextInt(4) + 2; // 2 to 5
                gold += houseGold;
                message = "You entered a house and earned " + houseGold + " gold. (" + date.toString() + ")";
                earns.add(message);
                break;

            case "quest":
                int questGold = random.nextInt(101) - 50; // -50 to 50
                gold += questGold;
                if (questGold >= 0) {
                    message = "You completed a quest and earned " + questGold + " gold. (" + date.toString() + ")";
                    earns.add(message);
                } else {
                    message = "You failed a quest and lost " + Math.abs(questGold) + " gold. Ouch. (" + date.toString() + ")";
                    lose.add(message);
                }
                break;

            case "spa":
                int spaGold = random.nextInt(16) + 5; // 5 to 20 (always subtract)
                gold -= spaGold;
                message = "You visited a spa and lost " + spaGold + " gold. Ouch. (" + date.toString() + ")";
                lose.add(message);
                break;

            case "reset":
                session.invalidate();
                return "redirect:/";

            default:
                flash.addFlashAttribute("error", "Invalid action!");
                return "redirect:/";
        }

        session.setAttribute("gold", gold);
        session.setAttribute("earns", earns);
        session.setAttribute("lose", lose);

        return "redirect:/";
    }
}
