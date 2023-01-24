package com.judah.dndbehind.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.judah.dndbehind.models.Campaign;

public interface CampaignRepository extends CrudRepository<Campaign, Long> {
	List<Campaign> findAll();
}
