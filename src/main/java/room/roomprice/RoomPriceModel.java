package room.roomprice;

public class RoomPriceModel {

    private String requestTime;//yyyy-MM-dd HH:mm:ss
    private String username;
    private String password;

    private String arriveTime;//抵达时间yyyy-MM-ddTHH:mm:ss
    private String day;//住多少天

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

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
