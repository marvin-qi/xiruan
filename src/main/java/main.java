import member.info.Info;
import member.info.InfoModel;
import member.login.Login;
import member.login.LoginModel;
import member.register.Register;
import member.register.RegisterModel;
import room.roomtype.RoomType;
import room.roomtype.RoomTypeModel;
import utils.RequestModelUtils;
import utils.RequestUtils;
import utils.callback.DataUtils;

public class main {

    public static void main(String args[]) {
        System.out.println("西软数据对接");
        member();
        room();
    }

    private static void room(){
        searchRoom();
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

    private static void info(){
        InfoModel model = new InfoModel();
        model.setRequestTime(RequestModelUtils.getRequestTimeString(RequestUtils.RequestType.member));
        model.setUsername(RequestModelUtils.username);
        model.setPassword(RequestModelUtils.password);

        model.setAccountId("K000113");

        Info.info(model, new DataUtils() {
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

    private static void searchRoom(){
        RoomTypeModel model = new RoomTypeModel();
        model.setRequestTime(RequestModelUtils.getRequestTimeString(RequestUtils.RequestType.room));
        model.setUsername(RequestModelUtils.username);
        model.setPassword(RequestModelUtils.password);

        RoomType.search(model, new DataUtils() {
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

