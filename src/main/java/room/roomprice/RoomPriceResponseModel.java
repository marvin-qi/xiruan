package room.roomprice;

import java.util.List;

public class RoomPriceResponseModel {

    /**
     * roomNum : {"roomNumber":""}
     * records : [{"roomInventoryCode":"","descript":"","ratelists":[{"rateCodeDes":"","ratecode":"","roomrate":"","package":""},{"rateCodeDes":"","ratecode":"","roomrate":"","package":""}],"surnum":""}]
     */

    private RoomNumBean roomNum;
    private List<RecordsBean> records;

    public RoomNumBean getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(RoomNumBean roomNum) {
        this.roomNum = roomNum;
    }

    public List<RecordsBean> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public static class RoomNumBean {
        /**
         * roomNumber :
         */

        private String roomNumber;

        public String getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }
    }

    public static class RecordsBean {
        /**
         * roomInventoryCode :
         * descript :
         * ratelists : [{"rateCodeDes":"","ratecode":"","roomrate":"","package":""},{"rateCodeDes":"","ratecode":"","roomrate":"","package":""}]
         * surnum :
         */

        private String roomInventoryCode;
        private String descript;
        private String surnum;
        private List<RatelistsBean> ratelists;

        public String getRoomInventoryCode() {
            return roomInventoryCode;
        }

        public void setRoomInventoryCode(String roomInventoryCode) {
            this.roomInventoryCode = roomInventoryCode;
        }

        public String getDescript() {
            return descript;
        }

        public void setDescript(String descript) {
            this.descript = descript;
        }

        public String getSurnum() {
            return surnum;
        }

        public void setSurnum(String surnum) {
            this.surnum = surnum;
        }

        public List<RatelistsBean> getRatelists() {
            return ratelists;
        }

        public void setRatelists(List<RatelistsBean> ratelists) {
            this.ratelists = ratelists;
        }

        public static class RatelistsBean {
            /**
             * rateCodeDes :
             * ratecode :
             * roomrate :
             * packageX :
             */

            private String rateCodeDes;
            private String ratecode;
            private String roomrate;
            private String packageX;

            public String getRateCodeDes() {
                return rateCodeDes;
            }

            public void setRateCodeDes(String rateCodeDes) {
                this.rateCodeDes = rateCodeDes;
            }

            public String getRatecode() {
                return ratecode;
            }

            public void setRatecode(String ratecode) {
                this.ratecode = ratecode;
            }

            public String getRoomrate() {
                return roomrate;
            }

            public void setRoomrate(String roomrate) {
                this.roomrate = roomrate;
            }

            public String getPackageX() {
                return packageX;
            }

            public void setPackageX(String packageX) {
                this.packageX = packageX;
            }
        }
    }
}
