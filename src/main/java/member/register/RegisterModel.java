package member.register;

public class RegisterModel {
    private String requestTime;//yyyy-MM-dd HH:mm:ss
    private String username;
    private String password;
    private String gender;//男MALE,女FEMALE
    private String nameTitle;//Mr, Ms
    private String nameFirst;//姓
    private String nameLast;//名
    private String vipTag;//会员卡标记，由酒店提供。默认 B: 补卡 N:新卡 U:续卡
    private String programType;//根据微信网站设置的卡等级值
    private String userPassword;//用户密码
    private String accountSno;//第二卡号,可以是用我们数据库的用户id代替
    private String phoneNumber;//手机号

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getVipTag() {
        return vipTag;
    }

    public void setVipTag(String vipTag) {
        this.vipTag = vipTag;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAccountSno() {
        return accountSno;
    }

    public void setAccountSno(String accountSno) {
        this.accountSno = accountSno;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
