import member.info.Info;
import member.info.InfoModel;
import member.login.Login;
import member.login.LoginModel;
import member.register.Register;
import member.register.RegisterModel;
import pay.Pay;
import pay.PayModel;
import room.roomprice.RoomPrice;
import room.roomprice.RoomPriceModel;
import room.roomreserve.RoomReserve;
import room.roomreserve.RoomReserveModel;
import room.roomreservecancel.RoomReserveCancel;
import room.roomreservecancel.RoomReserveCancelModel;
import room.roomtype.RoomType;
import room.roomtype.RoomTypeModel;
import utils.RequestModelUtils;
import utils.RequestUtils;
import utils.callback.DataUtils;

public class main {

    public static void main(String args[]) {
        System.out.println("西软数据对接");
//        member();
        room();
    }

    private static void room(){
//        searchRoom();
//        queryRoom();
//        reserve();
//        cancel();
        pay();
    }

    private static void member(){
//        register();
//        login();
        info();
    }

    private static void register(){
        RegisterModel model = new RegisterModel();
        model.setRequestTime(RequestModelUtils.getRequestTimeString(RequestUtils.RequestType.member));
        model.setUsername(RequestModelUtils.username);
        model.setPassword(RequestModelUtils.password);
        model.setGender("MALE");
        model.setNameTitle("Mr");
        model.setNameFirst("祁");
        model.setNameLast("鹏翔");
        model.setVipTag("N");
        model.setProgramType("A");
        model.setUserPassword("000000");
        model.setAccountSno("001");
        model.setPhoneNumber("18952365921");
        Register.request(model, new DataUtils() {
            public void onSuccess(Object object) {
                System.out.println(object.toString());
            }

            public void onFailure(String msg) {
                System.out.println(msg);
            }
        });
    }

    private static void login(){
        LoginModel model = new LoginModel();
        model.setRequestTime(RequestModelUtils.getRequestTimeString(RequestUtils.RequestType.member));
        model.setUsername(RequestModelUtils.username);
        model.setPassword(RequestModelUtils.password);

        model.setId("K000113");
        model.setUserPassword("000000");
        model.setLoginType("LOG_CARD");
        model.setCardType("1");
        Login.login(model, new DataUtils() {
            public void onSuccess(Object object) {
                System.out.println(object.toString());
            }

            public void onFailure(String msg) {
                System.out.println(msg);
            }
        });
    }

    private static void info(){
        InfoModel model = new InfoModel();
        model.setRequestTime(RequestModelUtils.getRequestTimeString(RequestUtils.RequestType.member));
        model.setUsername(RequestModelUtils.username);
        model.setPassword(RequestModelUtils.password);

        model.setAccountId("K000113");

        Info.info(model, new DataUtils() {
            public void onSuccess(Object object) {
                System.out.println(object.toString());
            }

            public void onFailure(String msg) {
                System.out.println(msg);
            }
        });
    }

    private static void searchRoom(){
        RoomTypeModel model = new RoomTypeModel();
        model.setRequestTime(RequestModelUtils.getRequestTimeString(RequestUtils.RequestType.room));
        model.setUsername(RequestModelUtils.username);
        model.setPassword(RequestModelUtils.password);

        RoomType.search(model, new DataUtils() {
            public void onSuccess(Object object) {
                System.out.println(object.toString());
            }

            public void onFailure(String msg) {
                System.out.println(msg);
            }
        });
    }

    private static void queryRoom(){
        RoomPriceModel model = new RoomPriceModel();
        model.setRequestTime(RequestModelUtils.getRequestTimeString(RequestUtils.RequestType.room));
        model.setUsername(RequestModelUtils.username);
        model.setPassword(RequestModelUtils.password);

        model.setArriveTime("2019-11-25T16:00:00");
        model.setDay("4");
        RoomPrice.query(model, new DataUtils() {
            public void onSuccess(Object object) {
                System.out.println(object.toString());
            }

            public void onFailure(String msg) {
                System.out.println(msg);
            }
        });
    }

    private static void reserve(){
        RoomReserveModel model = new RoomReserveModel();
        model.setRequestTime(RequestModelUtils.getRequestTimeString(RequestUtils.RequestType.room));
        model.setUsername(RequestModelUtils.username);
        model.setPassword(RequestModelUtils.password);

        model.setRoomInventory("BSQ");
        model.setNumberOfTimeUnits("2");
        model.setRatePlanCode("RAC");
        model.setResConmentRPHs("13912345678");
        model.setResProfileRPHs("张三");
        model.setNumRooms("2");
        model.setNote("备注一下");
        model.setNameTitle("Mr");
        model.setNameFirst("祁");
        model.setNameLast("鹏翔");
        model.setGender("MALE");
        model.setArriveTime("2019-11-25 16:00:00");
        model.setArriveTimeEnd("17:00");
        model.setAdultUserCount("2");
        model.setChildUserCount("1");

        RoomReserve.reserve(model, new DataUtils() {
            public void onSuccess(Object object) {
                System.out.println(object.toString());
            }

            public void onFailure(String msg) {
                System.out.println(msg);
            }
        });
    }

    private static void cancel(){
        RoomReserveCancelModel model = new RoomReserveCancelModel();
        model.setRequestTime(RequestModelUtils.getRequestTimeString(RequestUtils.RequestType.room));
        model.setUsername(RequestModelUtils.username);
        model.setPassword(RequestModelUtils.password);

        model.setOrderId("F18I170037");
        RoomReserveCancel.cancel(model, new DataUtils() {
            public void onSuccess(Object object) {
                System.out.println(object.toString());
            }

            public void onFailure(String msg) {
                System.out.println(msg);
            }
        });
    }

    private static void pay(){
        PayModel model = new PayModel();
        model.setRequestTime(RequestModelUtils.getRequestTimeString(RequestUtils.RequestType.room));
        model.setUsername(RequestModelUtils.username);
        model.setPassword(RequestModelUtils.password);

//        private String orderId;//订单号
        model.setOrderId("F18I170038");
//        private String payCode;//酒店微支付对应的付款码, 或者费用码
        model.setPayCode("9005");
//        private String cashOrderNo;//单号
//        model.setCashOrderNo("");
//        private String amount;//金额
        model.setAmount("1000.00");
//        private String remark;//微支付交易号
        model.setRemark("RYZ2019112320000001");
//        private String resType;//预订类型, 默认 6PM, 需与酒店确认
        model.setResType("6PM");
//        private String folio;//单据编号, 最长10位,可以数字或者字符
        model.setFolio("5255625");
        Pay.pay(model, new DataUtils() {
            @Override
            public void onSuccess(Object object) {
                System.out.println(object.toString());
            }

            @Override
            public void onFailure(String msg) {
                System.out.println(msg);
            }
        });
    }


}

