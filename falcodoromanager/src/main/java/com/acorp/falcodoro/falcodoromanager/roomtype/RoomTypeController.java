package com.acorp.falcodoro.falcodoromanager.roomtype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/roomtype")
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping(path = "/findall")
    public List<RoomTypeModel> getAllRoomTypes(){
        return roomTypeService.retrieveAll();
    }

    @DeleteMapping(path = "/delete")
    public void deleteRoomType(RoomTypeModel roomTypeModel){
        roomTypeService.delete(roomTypeModel);
    }

    @PostMapping(path = "/save")
    public void insertRoomType(RoomTypeModel roomTypeModel){
        roomTypeService.addRoomType(roomTypeModel);
    }

    @PutMapping(path = "/update")
    public void updateRoomType(RoomTypeModel roomTypeModel){
        roomTypeService.updateRoomType(roomTypeModel);
    }

    @GetMapping(path = "/deletebyid/{id}")
    public void deleteRoomTypeById(@PathVariable("id") long id){
        roomTypeService.deleteById(id);
    }

}
