package com.judah.dndbehind.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.judah.dndbehind.services.CampaignService;
import com.judah.dndbehind.services.CharacterService;
import com.judah.dndbehind.services.UserService;

@Controller
public class MainController {

	private final CharacterService characterServ;
	private final UserService userServ;
	private final CampaignService campaignServ;

	public MainController(UserService userServ, CharacterService characterServ, CampaignService campaignServ) {
		this.userServ = userServ;
		this.characterServ = characterServ;
		this.campaignServ = campaignServ;
	}

	@GetMapping("/campaigns")
	public String dashboard(HttpSession session, Model model) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/users/login";
		}
		model.addAttribute("allCharacters", characterServ.getAll());
		model.addAttribute("allCampaigns", campaignServ.getAll());
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		return "main/dashboard.jsp";
	}
}
