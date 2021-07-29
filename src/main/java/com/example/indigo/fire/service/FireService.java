package com.example.indigo.fire.service;

import com.example.indigo.fire.domain.Fire;
import com.example.indigo.fire.domain.FireRepository;
import com.example.indigo.fire.domain.FireStatus;
import com.example.indigo.fire.dto.AddForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FireService {

    @Autowired
    FireRepository fireRepository;

    public Long add(AddForm form){
        Fire fire = new Fire(form);
        return fireRepository.save(fire).getId();
    }

    public Fire breakOut(Long id){
        Fire fire =  fireRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Not in database id= " + id));
        fire.setBreakOut();
        fireRepository.save(fire);
        return fire;
    }

    public Fire contain(Long id){
        Fire fire = fireRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Not in database id= " + id));
        fire.setContain();
        fireRepository.save(fire);
        return fire;
    }

    public Fire putOut(Long id){
        Fire fire = fireRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Not in database id= " + id));
        fire.setPutOut();
        fireRepository.save(fire);
        return fire;
    }

    public List<Fire> getList(){
        return fireRepository.findAll().stream().toList();
    }

    public List<Fire> getContainList(){
        return fireRepository.findAll().stream().filter(Fire::isContain).collect(Collectors.toList());
    }

    public List<Fire> getPutOutList(){
        return fireRepository.findAll().stream().filter(Fire::isPutOut).collect(Collectors.toList());
    }
}
