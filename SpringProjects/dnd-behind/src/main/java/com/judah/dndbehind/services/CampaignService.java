package com.judah.dndbehind.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.judah.dndbehind.models.Campaign;
import com.judah.dndbehind.repositories.CampaignRepository;

@Service
public class CampaignService {

	private final CampaignRepository campaignRepo;

	public CampaignService(CampaignRepository campaignRepo) {
		this.campaignRepo = campaignRepo;
	}

	public Campaign getOne(Long id) {
		Optional<Campaign> campaign = campaignRepo.findById(id);
		return campaign.isPresent() ? campaign.get() : null;
	}

	public List<Campaign> getAll() {
		return (List<Campaign>) campaignRepo.findAll();
	}

	public Campaign create(Campaign campaign) {
		return campaignRepo.save(campaign);
	}

	public Campaign update(Campaign campaign) {
		return campaignRepo.save(campaign);
	}

	public String deleteById(Long id) {
		campaignRepo.deleteById(id);
		return "You have deleted an instance w/ an id of:" + id;
	}

}
