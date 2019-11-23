package room.roomprice;

import utils.RequestModelUtils;
import utils.RequestUtils;
import utils.callback.DataUtils;
import utils.callback.ResponseUtils;

import java.util.ArrayList;
import java.util.List;

public class RoomPrice {

    public static void query(RoomPriceModel params, DataUtils callBack){
        RequestUtils.request(RequestUtils.RequestType.room, "RateQueryByCusNo", "xml", getRequestXml(params), new ResponseUtils() {
            @Override
            public void onResponse(String response) {
                if (response.contains("<retcode>00001</retcode>")){
                    int start = response.indexOf("<Body>");
                    int end = response.indexOf("</Body>");
                    String data = response.substring(start + 6, end);
                    if (null != callBack){
                        callBack.onSuccess(unzip(data));
                    }
                }else {
                    if (null != callBack){
                        callBack.onFailure("获取房价失败");
                    }
                }
            }
        });
    }

    private static String getRequestXml(RoomPriceModel model){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        buffer.append("<Request>\n");
        buffer.append("<Head>\n");
        buffer.append("<transcode>10</transcode>\n");
        buffer.append("<reqtime>" + model.getRequestTime() + "</reqtime>\n");
        buffer.append("<systype>1020</systype>\n");
        buffer.append("<username> " + model.getUsername() + "</username>\n");
        buffer.append("<password> " + model.getPassword() + "</password>\n");
        buffer.append("</Head>\n");
        buffer.append("<Body>\n");
        buffer.append("<RatePlans>\n");
        buffer.append("<RatePlan reservationActionType=\"CHANGE\">\n");
        buffer.append("<ratePlanCode>RAC</ratePlanCode> //如果传入这个值,则openid对应的会员价不再生效\n");
        buffer.append("<TimeSpan timeUnitType=\"DAY\">\n");
        buffer.append("<startTime>" + model.getArriveTime() + "</startTime> //抵达时间\n");
        buffer.append("<numberOfTimeUnits>" + model.getDay() + "</numberOfTimeUnits> //房晚\n");
        buffer.append("</TimeSpan>\n");
        buffer.append("<Rates>\n");
        buffer.append("<Rate reservationActionType=\"CHANGE\" rateBasisTimeUnitType=\"DAY\"></Rate>\n");
        buffer.append("</Rates>\n");
        buffer.append("<CusNo>" + RequestModelUtils.cusNo + "</CusNo> //协议单位号\n");
        buffer.append("</RatePlan>\n");
        buffer.append("</RatePlans>\n");
        buffer.append("</Body>\n");
        buffer.append("</Request>");
        return buffer.toString();
    }

    private static RoomPriceResponseModel unzip(String data){
        RoomPriceResponseModel model = new RoomPriceResponseModel();
        String[] rms = data.split("</record>");
        List<RoomPriceResponseModel.RecordsBean> rooms = new ArrayList<>();
        for (int i = 0; i < rms.length; i++) {
            RoomPriceResponseModel.RecordsBean record = new RoomPriceResponseModel.RecordsBean();
            List<RoomPriceResponseModel.RecordsBean.RatelistsBean> rates = new ArrayList();
            String room = rms[i];
            if (i == 0){
                if (room.contains("<roomNum>")){
                    RoomPriceResponseModel.RoomNumBean bean = new RoomPriceResponseModel.RoomNumBean();
                    int start = room.indexOf("<roomNumber>");
                    int end = room.indexOf("</roomNumber>");
                    if (start == end){
                        bean.setRoomNumber("0");
                    }else {
                        String roomNumber = room.substring(start + 12, end);
                        bean.setRoomNumber(roomNumber);
                    }
                    model.setRoomNum(bean);
                }
                int idx = room.indexOf("<record>");
                room = room.substring(idx);
            }
            room = room.replaceAll("<record>", "");
            int start = room.indexOf("<roomInventoryCode>");
            int end = room.indexOf("</roomInventoryCode>");
            String roomInventoryCode = room.substring(start + 19, end);
            record.setRoomInventoryCode(roomInventoryCode);

            start = room.indexOf("<descript>");
            end = room.indexOf("</descript>");
            String descript = room.substring(start + 10, end);
            record.setDescript(descript);

            start = room.indexOf("<surnum>");
            end = room.indexOf("</surnum>");
            String surnum = room.substring(start + 8, end);
            record.setSurnum(surnum);

            String[] rateString = room.split("</ratelist>");
            for (String rate : rateString) {
                System.out.println(rate);
                if (!rate.contains("<ratelist>")){
                    continue;
                }
                int idx = rate.indexOf("<ratelist>");
                rate = rate.substring(idx + 10);
                RoomPriceResponseModel.RecordsBean.RatelistsBean bean = new RoomPriceResponseModel.RecordsBean.RatelistsBean();
                start = rate.indexOf("<rateCodeDes>");
                end = rate.indexOf("</rateCodeDes>");
                String rateCodeDes = rate.substring(start + 13, end);
                bean.setRateCodeDes(rateCodeDes);

                start = rate.indexOf("<ratecode>");
                end = rate.indexOf("</ratecode>");
                String ratecode = rate.substring(start + 10, end);
                bean.setRatecode(ratecode);

                start = rate.indexOf("<roomrate>");
                end = rate.indexOf("</roomrate>");
                String roomrate = rate.substring(start + 10, end);
                bean.setRoomrate(roomrate);

                start = rate.indexOf("<package>");
                end = rate.indexOf("</package>");
                if (start == end){
                    bean.setPackageX("0");
                }else {
                    String packageX = rate.substring(start + 9, end);
                    bean.setPackageX(packageX);
                }
                rates.add(bean);
            }
            record.setRatelists(rates);
            rooms.add(record);
        }
        model.setRecords(rooms);
        return model;
    }

}
