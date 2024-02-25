package com.liveasy.controller;

import com.liveasy.entity.Load;
import com.liveasy.payload.LoadDto;
import com.liveasy.response.ResponseHandler;
import com.liveasy.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;


@RestController
@RequestMapping("/api")
public class LoadController {
    @Autowired
    private LoadService loadService;

    @PostMapping("/load")
    public ResponseEntity<Object>create(@RequestBody LoadDto loadDto){
        LoadDto loadDto1 = this.loadService.create(loadDto);
        return ResponseHandler.responseBuilder("loads details added successfully", HttpStatus.OK,loadDto1);
    }
    @GetMapping("{shipperId}")
    public ResponseEntity<Load> getLoadByShipperId(@PathVariable("shipperId") int shipperId) {
        ResponseEntity<Load> matchingLoad = new ResponseEntity<Load>(loadService.getLoadByShipperId(shipperId), HttpStatus.OK);
        return matchingLoad;
    }
    @GetMapping("{loadId}")
    public ResponseEntity<LoadDto> getLoadByLoadId(@PathVariable("loadId") int loadId) {
        return ResponseEntity.ok(this.loadService.getLoadByLoadId(loadId));
    }

//    @DeleteMapping("{loadId}")
//    public ResponseEntity<Object>deleteLoad(@PathVariable("loadId") int loadId){
//        LoadDto loadDelete = this.loadService.deleteLoad(loadId);
//        return ResponseHandler.responseBuilder("Deleted Successfully",HttpStatus.OK,loadDelete);
//    }
}
