package com.example.indigo.fire.controller;

import com.example.indigo.fire.domain.Fire;
import com.example.indigo.fire.dto.AddForm;
import com.example.indigo.fire.service.FireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/fire")
@RestController
public class FireController {

    // 1. first add information of cam's position
    // 2. update fire status when break out and get fire info
    // 3. update fire status when break out to contain
    // 4. update fire status when contain to put out
    // 5. get contain list
    // 6. get put out list

    @Autowired
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

    @PutMapping("/put-out/{id}")
    public Fire putOut(@PathVariable Long id){
        return fireService.putOut(id);
    }

    @GetMapping("/list")
    public List<Fire> getList() {
        return fireService.getList();
    }

    @GetMapping("/list/contain")
    public List<Fire> getContainList(){
        return fireService.getContainList();
    }

    @GetMapping("/list/put-out")
    public List<Fire> getPutOutList(){
        return fireService.getPutOutList();
    }
}
