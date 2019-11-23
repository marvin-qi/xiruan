package member.login;

public class LoginModel{
    private String requestTime;//yyyy-MM-dd HH:mm:ss
    private String username;
    private String password;

    private String id;//ID 可填卡号/手机号/邮箱Logintype 对应为 LOG_CARD/ LOG_PHONE/ LOG_EMAIL
    private String userPassword;
    private String loginType;// 可填卡号/手机号/邮箱Logintype 对应为 LOG_CARD/ LOG_PHONE/ LOG_EMAIL
    private String cardType;//1

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
