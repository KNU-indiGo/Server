package com.example.indigo.fire.service;

import com.example.indigo.fire.domain.Fire;
import com.example.indigo.fire.domain.FireRepository;
import com.example.indigo.fire.domain.FireStatus;
import com.example.indigo.fire.dto.AddForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FireService {

    private FireRepository fireRepository;

    public Long add(AddForm form){
        Fire fire = new Fire(form);
        return fireRepository.save(fire).getId();
    }

    public Fire breakOut(Long id){
        Fire fire =  fireRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Not in database id= " + id));
        fire.setStatus(FireStatus.BREAKOUT);
        return fire;
    }

    public Fire contain(Long id){
        Fire fire = fireRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Not in database id= " + id));
        fire.setStatus(FireStatus.CONTAIN);
        return fire;
    }

    public Fire putOut(Long id){
        Fire fire = fireRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Not in database id= " + id));
        fire.setStatus(FireStatus.PUTOUT);
        return fire;
    }

    public List<Fire> getContainList(){
        return fireRepository.findAll().stream().filter(Fire::isContain).collect(Collectors.toList());
    }

    public List<Fire> getPutOutList(){
        return fireRepository.findAll().stream().filter(Fire::isPutOut).collect(Collectors.toList());
    }
}
