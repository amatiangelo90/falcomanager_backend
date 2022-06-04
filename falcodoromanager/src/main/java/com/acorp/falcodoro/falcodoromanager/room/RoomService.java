package com.acorp.falcodoro.falcodoromanager.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomModel> retrieveAll() {
        return roomRepository.findAll();
    }

    public void save(RoomModel roomModel) {
        roomRepository.save(roomModel);

    }

    @Transactional
    public void update(RoomModel roomModel) {
        RoomModel roomRetrieved = roomRepository.findById(roomModel.getRoomId()).orElseThrow(()
                -> new IllegalStateException("Room with id "+ roomModel.getRoomId()+" not found"));

        if(roomRepository.findByRoomNumber(roomModel.getRoomNumber()).isPresent()){
            throw new IllegalStateException("Number room " + roomModel.getRoomNumber() + " is already taken. Choose different number");
        }else{
            roomRetrieved.setRoomNumber(roomModel.getRoomNumber());
        }

        if(roomModel.getName() != null &&
                roomModel.getName().length() > 0 &&
                !Objects.equals(roomModel.getName(), roomRetrieved.getName())){

            roomRetrieved.setName(roomModel.getName());
        }
        if(roomModel.getRoomTypeModel() != null && roomModel.getRoomTypeModel().toString().length() != 0){
            roomRetrieved.setRoomTypeModel(roomModel.getRoomTypeModel());
        }
    }

    public void delete(RoomModel roomModel) {
        roomRepository.delete(roomModel);
    }
}
