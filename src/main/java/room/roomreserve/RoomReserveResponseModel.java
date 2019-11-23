package room.roomreserve;

public class RoomReserveResponseModel {
    private String numRooms;//房间数
    private String credit;
    private String ispayed;//是否已经支付
    private String confirmationID;//PMS订单号
    private String resNo;//预订号
    private String profileID;//会员档案号
    private String roomInventoryCode;//房型
    private String startTime;//抵达日期
    private String numberOfTimeUnits;//房晚

    public String getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(String numRooms) {
        this.numRooms = numRooms;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getIspayed() {
        return ispayed;
    }

    public void setIspayed(String ispayed) {
        this.ispayed = ispayed;
    }

    public String getConfirmationID() {
        return confirmationID;
    }

    public void setConfirmationID(String confirmationID) {
        this.confirmationID = confirmationID;
    }

    public String getResNo() {
        return resNo;
    }

    public void setResNo(String resNo) {
        this.resNo = resNo;
    }

    public String getProfileID() {
        return profileID;
    }

    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    public String getRoomInventoryCode() {
        return roomInventoryCode;
    }

    public void setRoomInventoryCode(String roomInventoryCode) {
        this.roomInventoryCode = roomInventoryCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getNumberOfTimeUnits() {
        return numberOfTimeUnits;
    }

    public void setNumberOfTimeUnits(String numberOfTimeUnits) {
        this.numberOfTimeUnits = numberOfTimeUnits;
    }
}
