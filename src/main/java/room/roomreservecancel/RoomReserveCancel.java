package room.roomreservecancel;

import utils.RequestUtils;
import utils.callback.DataUtils;
import utils.callback.ResponseUtils;

public class RoomReserveCancel {

    public static void cancel(RoomReserveCancelModel params, DataUtils callBack){
        RequestUtils.request(RequestUtils.RequestType.room, "ResCancel", "xml", getRequestXml(params), new ResponseUtils() {
            @Override
            public void onResponse(String response) {
                if (response.contains("<retcode>00001</retcode>")){
                    if (null != callBack){
                        callBack.onSuccess("取消成功");
                    }
                }else {
                    if (null != callBack){
                        callBack.onFailure("取消失败");
                    }
                }
            }
        });
    }

    private static String getRequestXml(RoomReserveCancelModel model){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
        buffer.append("<Request>\n");
        buffer.append("<Head>\n");
        buffer.append("<transcode>10</transcode>\n");
        buffer.append("<reqtime>" + model.getRequestTime() + "</reqtime>\n");
        buffer.append("<systype>1010</systype>\n");
        buffer.append("<username> " + model.getUsername() + "</username>\n");
        buffer.append("<password> " + model.getPassword() + "</password>\n");
        buffer.append("</Head>\n");
        buffer.append("<Body>\n");
        buffer.append("<ReservationCancel>\n");
        buffer.append("<confirmationID>" + model.getOrderId() + "</confirmationID> //从预订查询中得到的预订单号\n");
        buffer.append("</ReservationCancel>\n");
        buffer.append("</Body>\n");
        buffer.append("</Request>");
        return buffer.toString();
    }

    private static RoomReserveCancelResponseModel unzip(String xml){
        RoomReserveCancelResponseModel data = new RoomReserveCancelResponseModel();

        return data;
    }


}
