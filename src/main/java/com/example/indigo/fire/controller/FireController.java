package com.example.indigo.fire.controller;

import com.example.indigo.fire.domain.Fire;
import com.example.indigo.fire.dto.AddForm;
import com.example.indigo.fire.service.FireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/fire")
@RestController
public class FireController {

    // To do List
    // 1. first add information of cam's position
    // 2. update fire status when break out and get fire info
    // 3. update fire status when break out to contain
    // 4. update fire status when contain to put out
    // 4. get contain list
    // 5. get put out list

    private FireService fireService;

    @PostMapping(value = "/add", produces = "application/json; charset=utf8")
    public Long add(@RequestBody AddForm form) {
        return fireService.add(form);
    }

    @PutMapping("/break-out/{id}")
    public Fire breakOut(@PathVariable Long id){
        return fireService.breakOut(id);
    }

    @PutMapping("/contain/{id}")
    public Fire contain(@PathVariable Long id){
        return fireService.contain(id);
    }

    @PutMapping("/safe/{id}")
    public Fire safe(@PathVariable Long id){
        return fireService.putOut(id);
    }

    @GetMapping("/list/contain")
    public List<Fire> getContainList(){
        return fireService.getContainList();
    }

    @GetMapping("/list/putout")
    public List<Fire> getPutOutList(){
        return fireService.getPutOutList();
    }
}
