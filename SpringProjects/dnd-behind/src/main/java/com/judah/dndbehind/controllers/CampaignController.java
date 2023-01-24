package com.judah.dndbehind.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.judah.dndbehind.services.CampaignService;
import com.judah.dndbehind.services.UserService;
import com.judah.dndbehind.models.Campaign;

@Controller
@RequestMapping("/campaigns")
public class CampaignController {

	private final CampaignService campaignServ;
	private final UserService userServ;

	public CampaignController(CampaignService campaignServ, UserService userServ) {
		this.campaignServ = campaignServ;
		this.userServ = userServ;
	}

	@GetMapping("/create")
	public String createCampaign(@ModelAttribute("campaign") Campaign campaign, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/campaigns";
		}
		return "campaign/newCampaign.jsp";
	}

	@PostMapping("/create")
	public String processCreateCampaign(@Valid @ModelAttribute("campaign") Campaign campaign, BindingResult result) {
		if (result.hasErrors()) {
			return "campaign/newCampaign.jsp";
		}
		campaignServ.create(campaign);
		return "redirect:/campaigns";
	}

	@GetMapping("/edit/{id}")
	public String editCampaign(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/campaigns";
		}
		Campaign campaign = campaignServ.getOne(id);
		model.addAttribute("campaign", campaign);
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		return "campaign/editCampaign.jsp";
	}

	@PutMapping("/edit/{id}")
	public String processEditCampaign(@PathVariable("id") Long id, @Valid @ModelAttribute("campaign") Campaign campaign,
			BindingResult result) {
		if (result.hasErrors()) {
			return "campaign/editCampaign.jsp";
		}
		campaignServ.update(campaign);
		return "redirect:/campaigns";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCampaign(@PathVariable("id") Long id) {
		System.out.println("got here");
		campaignServ.deleteById(id);
		return "redirect:/campaigns";
	}

	@GetMapping("/view/{id}")
	public String viewCampaign(@PathVariable("id") Long id, Model model, HttpSession session) {
		Campaign campaign = campaignServ.getOne(id);
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		model.addAttribute("campaign", campaign);
		return "campaign/viewCampaign.jsp";
	}
}
