package room.roomreserve;

public class RoomReserveModel {

    private String requestTime;//yyyy-MM-dd HH:mm:ss
    private String username;
    private String password;

    private String roomInventory;//房型
    private String roomNo;//可以不传----------------------此节点有值--房号，则房间数必须为 1，否则预订失败
    private String numberOfTimeUnits;//房晚
    private String ratePlanCode;//房价码
    private String mfMartketCode;//可以不传----------------------市场码
    private String mfchannelCode;//可以不传----------------------渠道码
    private String resConmentRPHs;//可以不传----------------------预定人联系方式
    private String resProfileRPHs;//可以不传----------------------预定人姓名
    private String numRooms;//房间数

    private String note;//备注 ""
    private String nameTitle;//Mr, Ms
    private String nameFirst;//姓
    private String nameLast;//名
    private String gender;//性别MALE,FEMALE

    private String arriveTime;//到店时间
    private String arriveTimeEnd;//最晚到店时间 HH:mm

    private String adultUserCount;//成人人数
    private String childUserCount;//儿童人数

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getArriveTimeEnd() {
        return arriveTimeEnd;
    }

    public void setArriveTimeEnd(String arriveTimeEnd) {
        this.arriveTimeEnd = arriveTimeEnd;
    }

    public String getAdultUserCount() {
        return adultUserCount;
    }

    public void setAdultUserCount(String adultUserCount) {
        this.adultUserCount = adultUserCount;
    }

    public String getChildUserCount() {
        return childUserCount;
    }

    public void setChildUserCount(String childUserCount) {
        this.childUserCount = childUserCount;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoomInventory() {
        return roomInventory;
    }

    public void setRoomInventory(String roomInventory) {
        this.roomInventory = roomInventory;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getNumberOfTimeUnits() {
        return numberOfTimeUnits;
    }

    public void setNumberOfTimeUnits(String numberOfTimeUnits) {
        this.numberOfTimeUnits = numberOfTimeUnits;
    }

    public String getRatePlanCode() {
        return ratePlanCode;
    }

    public void setRatePlanCode(String ratePlanCode) {
        this.ratePlanCode = ratePlanCode;
    }

    public String getMfMartketCode() {
        return mfMartketCode;
    }

    public void setMfMartketCode(String mfMartketCode) {
        this.mfMartketCode = mfMartketCode;
    }

    public String getMfchannelCode() {
        return mfchannelCode;
    }

    public void setMfchannelCode(String mfchannelCode) {
        this.mfchannelCode = mfchannelCode;
    }

    public String getResConmentRPHs() {
        return resConmentRPHs;
    }

    public void setResConmentRPHs(String resConmentRPHs) {
        this.resConmentRPHs = resConmentRPHs;
    }

    public String getResProfileRPHs() {
        return resProfileRPHs;
    }

    public void setResProfileRPHs(String resProfileRPHs) {
        this.resProfileRPHs = resProfileRPHs;
    }

    public String getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(String numRooms) {
        this.numRooms = numRooms;
    }
}
