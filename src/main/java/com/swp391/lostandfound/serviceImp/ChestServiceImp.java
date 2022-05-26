package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.DTO.ChestAddDTO;
import com.swp391.lostandfound.DTO.ChestUpdateDTO;
import com.swp391.lostandfound.entity.Chest;
import com.swp391.lostandfound.repository.ChestRepository;
import com.swp391.lostandfound.service.ChestService;

import org.springframework.stereotype.Service;

@Service
public class ChestServiceImp implements ChestService {

    private ChestRepository chestRepository;

    public ChestServiceImp(ChestRepository chestRepository) {
        this.chestRepository = chestRepository;
    }

    @Override
    public List<Chest> getAllChests() {
        return chestRepository.findChestByStatus(0);
    }

    @Override
    public Chest addChest(ChestAddDTO chestAddDTO) {
        Chest chest = new Chest();
        chest.setDescription(chestAddDTO.getDescription());
        chest.setName(chestAddDTO.getName());
        chest.setLocation(chestAddDTO.getLocation());
        chest.setStatus(0);
        return chestRepository.save(chest);
    }

    @Override
    public Chest updateChest(int id, ChestUpdateDTO chestUpdateDTO) {
        if (chestRepository.existsById(id)) {
            Chest chest = chestRepository.findById(id).get();
            chest.setName(chestUpdateDTO.getName());
            chest.setDescription(chestUpdateDTO.getDescription());
            chest.setLocation(chestUpdateDTO.getLocation());
            chest.setStatus(chestUpdateDTO.getStatus());
            return chestRepository.save(chest);
        } else
            return null;
    }

    @Override
    public Chest findChestById(int id) {
        if (chestRepository.existsById(id)) {
            return chestRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean deleteChestById(int id) {
        if (chestRepository.existsById(id)) {
            chestRepository.setFixedStatusFor(1, id);
            return true;
        }
        return false;
    }

}
