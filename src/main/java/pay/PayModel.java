package pay;

public class PayModel {
    private String requestTime;//yyyy-MM-dd HH:mm:ss
    private String username;
    private String password;

    private String orderId;//订单号
    private String payCode;//酒店微支付对应的付款码, 或者费用码
    private String cashOrderNo;//单号
    private String amount;//金额
    private String remark;//微支付交易号
    private String resType;//预订类型, 默认 6PM, 需与酒店确认
    private String folio;//单据编号, 最长10位,可以数字或者字符

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getCashOrderNo() {
        return cashOrderNo;
    }

    public void setCashOrderNo(String cashOrderNo) {
        this.cashOrderNo = cashOrderNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
}
