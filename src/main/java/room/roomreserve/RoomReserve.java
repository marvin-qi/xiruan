package room.roomreserve;

import utils.RequestModelUtils;
import utils.RequestUtils;
import utils.callback.DataUtils;
import utils.callback.ResponseUtils;

public class RoomReserve {

    public static void reserve(RoomReserveModel params, DataUtils callBack){
        RequestUtils.request(RequestUtils.RequestType.room, "Reservation", "xml", getRequestXml(params), new ResponseUtils() {
            @Override
            public void onResponse(String response) {
                if (response.contains("<retcode>00001</retcode>")){
                    int start = response.indexOf("<ReservationResponse>");
                    int end = response.indexOf("</ReservationResponse>");
                    String data = response.substring(start + 21, end);
                    if (null != callBack){
                        callBack.onSuccess(unzip(data));
                    }
                }else {
                    if (null != callBack){
                        callBack.onFailure("预定失败");
                    }
                }
            }
        });
    }

    private static RoomReserveResponseModel unzip(String xml){
        RoomReserveResponseModel data = new RoomReserveResponseModel();
        int start = xml.indexOf("<numRooms>");
        int end = xml.indexOf("</numRooms>");
        data.setNumRooms(xml.substring(start + 10, end));

        start = xml.indexOf("<ispayed>");
        end = xml.indexOf("</ispayed>");
        data.setIspayed(xml.substring(start + 9, end));

        start = xml.indexOf("<confirmationID>");
        end = xml.indexOf("</confirmationID>");
        data.setConfirmationID(xml.substring(start + 16, end));

        start = xml.indexOf("<resNo>");
        end = xml.indexOf("</resNo>");
        data.setResNo(xml.substring(start + 7, end));

        start = xml.indexOf("<profileID>");
        end = xml.indexOf("</profileID>");
        data.setProfileID(xml.substring(start + 11, end));

        start = xml.indexOf("<roomInventoryCode>");
        end = xml.indexOf("</roomInventoryCode>");
        data.setRoomInventoryCode(xml.substring(start + 19, end));

        start = xml.indexOf("<startTime>");
        end = xml.indexOf("</startTime>");
        data.setStartTime(xml.substring(start + 11, end));

        start = xml.indexOf("<numberOfTimeUnits>");
        end = xml.indexOf("</numberOfTimeUnits>");
        data.setNumberOfTimeUnits(xml.substring(start + 19, end));
        return data;
    }

    private static String getRequestXml(RoomReserveModel model){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        buffer.append("<Request>\n");
        buffer.append("<Head>\n");
        buffer.append("<transcode>10001</transcode>\n");
        buffer.append("<reqtime>" + model.getRequestTime() + "</reqtime>\n");
        buffer.append("<systype>1009</systype>\n");
        buffer.append("<username> " + model.getUsername() + "</username>\n");
        buffer.append("<password> " + model.getPassword() + "</password>\n");
        buffer.append("</Head>\n");
        buffer.append("<Body>\n");
        buffer.append("<Reservation mfShareAction=\"NA\" mfReservationAction=\"ADD\">\n");
        buffer.append("<reservationOriginatorCode>0351831</reservationOriginatorCode>//订房中心\n");
        buffer.append("<protocol>" + RequestModelUtils.cusNo + "</protocol>//协议单位.\n");//协议单位码
        buffer.append("<ResComments>\n");
        buffer.append("<ResComment reservationActionType=\"CHANGE\">\n");
        buffer.append("<comment>" + model.getNote() + "</comment>\n");
        buffer.append("</ResComment>\n");
        buffer.append("</ResComments>\n");
        buffer.append("<ResProfiles>\n");
        buffer.append("<ResProfile>\n");
        buffer.append("<Profile profileType=\"GUEST\" gender=\"" + model.getGender() + "\">\n");
        buffer.append("<IndividualName>\n");
        buffer.append("<nameTitle>" + model.getNameTitle() + "</nameTitle> //根据性别来确定Mr,Ms\n");
        buffer.append("<nameFirst>" + model.getNameFirst() + "</nameFirst> //姓 必填 分开\n");
        buffer.append("<nameSur>" + model.getNameLast() + "</nameSur> //名\n");
        buffer.append("</IndividualName>\n");
        buffer.append("<primaryLanguageID>C</primaryLanguageID>\n");
        buffer.append("</Profile>\n");
        buffer.append("</ResProfile>\n");
        buffer.append("</ResProfiles>\n");
        buffer.append("<RoomStays>\n");
        buffer.append("<RoomStay mfShareAction=\"NA\" mfReservationAction=\"ADD\"\n");
        buffer.append("reservationActionType=\"CHANGE\" reservationStatusType=\"RESERVED\">\n");
        buffer.append("<roomStayRPH/>\n");
        buffer.append("<roomInventoryCode>" + model.getRoomInventory() + "</roomInventoryCode>//房型\n");
//        buffer.append("<roomNo></roomNo>//房间号 *传此值，房间数必须为1\n");
        buffer.append("<TimeSpan timeUnitType=\"DAY\">\n");
        buffer.append("<startTime>" + model.getArriveTime() + "</startTime> //到店时间\n");
        buffer.append("<numberOfTimeUnits>" + model.getNumberOfTimeUnits() + "</numberOfTimeUnits> //房晚\n");
        buffer.append("<arrtime>" + model.getArriveTimeEnd() + "</arrtime>  //最晚到店时间\n");
        buffer.append("</TimeSpan>\n");
        buffer.append("<GuestCounts>\n");
        buffer.append("<GuestCount>\n");
        buffer.append("<ageQualifyingCode>ADULT</ageQualifyingCode>\n");
        buffer.append("<mfCount>" + model.getAdultUserCount() + "</mfCount> //成人人数\n");
        buffer.append("</GuestCount>\n");
        buffer.append("<GuestCount>\n");
        buffer.append("<ageQualifyingCode>CHILD</ageQualifyingCode>\n");
        buffer.append("<mfCount>" + model.getChildUserCount() + "</mfCount> //儿童人数\n");
        buffer.append("</GuestCount>\n");
        buffer.append("</GuestCounts>\n");
        buffer.append("<RatePlans>\n");
        buffer.append("<RatePlan reservationActionType=\"CHANGE\">\n");
        buffer.append("<ratePlanCode>" + model.getRatePlanCode() + "</ratePlanCode> //ELITE-RAC 为之前查询到的房价信息中的rateLists中的rateCode\n");
//        buffer.append("<mfsourceCode>B</mfsourceCode> //在微网站增加来源码的设置页面，最长3位\n");
//        buffer.append("<mfMarketCode>OW</mfMarketCode> //在微网站增加市场码的设置页面，最长3位\n");
        buffer.append("<numRooms>" + model.getNumRooms() + "</numRooms> //房间数\n");
        buffer.append("</RatePlan>\n");
        buffer.append("</RatePlans>\n");
//        buffer.append("<mfchannelCode>OW</mfchannelCode> //在微网站增加渠道码的设置页面，最长3位\n");
        buffer.append("</RoomStay>\n");
        buffer.append("</RoomStays>\n");
        buffer.append("<resCommentRPHs>" + model.getResConmentRPHs() + "</resCommentRPHs>\n");
        buffer.append("<resProfileRPHs>" + model.getResProfileRPHs() + "</resProfileRPHs>\n");
        buffer.append("<mfsaleid>销售员</mfsaleid >\n");
        buffer.append("</Reservation>\n");
        buffer.append("</Body>\n");
        buffer.append("</Request>");
        return buffer.toString();
    }

}
