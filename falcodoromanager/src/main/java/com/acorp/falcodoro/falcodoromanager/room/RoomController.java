package com.acorp.falcodoro.falcodoromanager.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/findall")
    public List<RoomModel> retrieveAll(){
        return roomService.retrieveAll();
    }

    @PostMapping(path = "/save")
    public void insertRoom(RoomModel roomModel){
        roomService.save(roomModel);
    }

    @PutMapping(path = "/update")
    public void updateRoom(RoomModel roomModel){
        roomService.update(roomModel);
    }

    @DeleteMapping(path = "/delete")
    public void deleteRoom(RoomModel roomModel) { roomService.delete(roomModel);}
}
