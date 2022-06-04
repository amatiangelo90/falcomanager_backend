package com.acorp.falcodoro.falcodoromanager.room;

import com.acorp.falcodoro.falcodoromanager.roomtype.RoomTypeModel;
import javax.persistence.*;


@Entity(name = "RoomModel")
@Table(name = "ROOM",
        uniqueConstraints = {
                @UniqueConstraint(name = "roomNumber", columnNames = "roomNumber")
        })
public class RoomModel {
    @Id
    @SequenceGenerator(
            name = "room_id",
            sequenceName = "room_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_id"
    )
    @Column(
            name = "room_id",
            updatable = false
    )
    private long roomId;
    private String name;
    @Column(
            nullable = true
    )
    private int roomNumber;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="typename", nullable=false)
    private RoomTypeModel roomTypeModel;

    public RoomModel() {}

    public RoomModel(String name, int roomNumber, RoomTypeModel roomTypeModel) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.roomTypeModel = roomTypeModel;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomTypeModel getRoomTypeModel() {
        return roomTypeModel;
    }

    public void setRoomTypeModel(RoomTypeModel roomTypeModel) {
        this.roomTypeModel = roomTypeModel;
    }
}
