package pay;

import utils.RequestUtils;
import utils.callback.DataUtils;
import utils.callback.ResponseUtils;

public class Pay {

    public static void pay(PayModel params, DataUtils callBack){
        RequestUtils.request(RequestUtils.RequestType.room, "ReservationCashment", "xml", getRequestXml(params), new ResponseUtils() {
            @Override
            public void onResponse(String response) {

            }
        });
    }

    private static String getRequestXml(PayModel model){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
        buffer.append("<Request>\n");
        buffer.append("<Head>\n");
        buffer.append("<transcode>10</transcode>\n");
        buffer.append("<reqtime>" + model.getRequestTime() + "</reqtime>\n");
        buffer.append("<systype>1031</systype>\n");
        buffer.append("<username> " + model.getUsername() + "</username>\n");
        buffer.append("<password> " + model.getPassword() + " </password>\n");
        buffer.append("</Head>\n");
        buffer.append("<Body>\n");
        buffer.append("<ReservationOperator>\n");
        buffer.append("<confirmationID>" + model.getOrderId() + "</confirmationID> //订单号\n");
        buffer.append("<paycode>" + model.getPayCode() + "</paycode> //酒店微支付对应的付款码, 或者费用码--\n");
//        buffer.append("<CashOrderNo>" + model.getCashOrderNo() + "</CashOrderNo> //--单号 可以不传--\n");
        buffer.append("<amount>" + model.getAmount() + "</amount> //支付金额-\n");
        buffer.append("<Operator>XR_WX</Operator> //固定: XR_WX -- \n");
        buffer.append("<remark>" + model.getRemark() + "</remark> //微支付交易号, 唯一,不能重复--\n");
        buffer.append("<resType>" + model.getResType() + "</resType> //预订类型, 默认 6PM, 需与酒店确认\n");
        buffer.append("<folio>" + model.getFolio() + "</folio> //单据编号, 最长10位,可以数字或者字符\n");
        buffer.append("</ReservationOperator>\n");
        buffer.append("</Body>\n");
        buffer.append("</Request>");
        return buffer.toString();
    }

    private static void unzip(){

    }
}
