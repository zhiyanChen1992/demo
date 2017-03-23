package com.example.administrator.ddbusdatatest.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class StaionInfo implements Serializable {


    /**
     * [{}data : [{"lat":"22.1313666667","lon":"113.5616166667","method":"locat","routeStaticinfo":[{"dir":"0","fistname":"媽閣總站","lastname":"九澳油庫","routecode":"0021A","routename":"21A","routetype":"10004","routeversion":"","stopxh":"17"},{"dir":"0","fistname":"聯生工業邨","lastname":"聯生工業邨","routecode":"00059","routename":"59","routetype":"10004","routeversion":"","stopxh":"7"}],"stacode":"10001","stalabel":"","staname":"石排灣馬路","stationcode":"C650","staversion":""},{"lat":"22.1315","lon":"113.5611666667","method":"locat","routeStaticinfo":[{"dir":"1","fistname":"九澳油庫","lastname":"媽閣總站","routecode":"0021A","routename":"21A","routetype":"10004","routeversion":"","stopxh":"20"}],"stacode":"10002","stalabel":"","staname":"路環小型賽車場","stationcode":"C651","staversion":""}]
     * header : {"status":"000"}}]
     */

    private HeaderBean header;
    private List<DataBean> data;

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class HeaderBean {
        /**
         * status : 000
         */

        private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static class DataBean {
        /**
         * lat : 22.1313666667
         * lon : 113.5616166667
         * method : locat
         * routeStaticinfo : [{"dir":"0","fistname":"媽閣總站","lastname":"九澳油庫","routecode":"0021A","routename":"21A","routetype":"10004","routeversion":"","stopxh":"17"},{"dir":"0","fistname":"聯生工業邨","lastname":"聯生工業邨","routecode":"00059","routename":"59","routetype":"10004","routeversion":"","stopxh":"7"}]
         * stacode : 10001
         * stalabel :
         * staname : 石排灣馬路
         * stationcode : C650
         * staversion :
         */

        private String lat;
        private String lon;
        private String method;
        private String stacode;
        private String stalabel;
        private String staname;
        private String stationcode;
        private String staversion;
        private List<RouteStaticinfoBean> routeStaticinfo;

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getStacode() {
            return stacode;
        }

        public void setStacode(String stacode) {
            this.stacode = stacode;
        }

        public String getStalabel() {
            return stalabel;
        }

        public void setStalabel(String stalabel) {
            this.stalabel = stalabel;
        }

        public String getStaname() {
            return staname;
        }

        public void setStaname(String staname) {
            this.staname = staname;
        }

        public String getStationcode() {
            return stationcode;
        }

        public void setStationcode(String stationcode) {
            this.stationcode = stationcode;
        }

        public String getStaversion() {
            return staversion;
        }

        public void setStaversion(String staversion) {
            this.staversion = staversion;
        }

        public List<RouteStaticinfoBean> getRouteStaticinfo() {
            return routeStaticinfo;
        }

        public void setRouteStaticinfo(List<RouteStaticinfoBean> routeStaticinfo) {
            this.routeStaticinfo = routeStaticinfo;
        }

        public static class RouteStaticinfoBean {
            /**
             * dir : 0
             * fistname : 媽閣總站
             * lastname : 九澳油庫
             * routecode : 0021A
             * routename : 21A
             * routetype : 10004
             * routeversion :
             * stopxh : 17
             */

            private String dir;
            private String fistname;
            private String lastname;
            private String routecode;
            private String routename;
            private String routetype;
            private String routeversion;
            private String stopxh;


            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getFistname() {
                return fistname;
            }

            public void setFistname(String fistname) {
                this.fistname = fistname;
            }

            public String getLastname() {
                return lastname;
            }

            public void setLastname(String lastname) {
                this.lastname = lastname;
            }

            public String getRoutecode() {
                return routecode;
            }

            public void setRoutecode(String routecode) {
                this.routecode = routecode;
            }

            public String getRoutename() {
                return routename;
            }

            public void setRoutename(String routename) {
                this.routename = routename;
            }

            public String getRoutetype() {
                return routetype;
            }

            public void setRoutetype(String routetype) {
                this.routetype = routetype;
            }

            public String getRouteversion() {
                return routeversion;
            }

            public void setRouteversion(String routeversion) {
                this.routeversion = routeversion;
            }

            public String getStopxh() {
                return stopxh;
            }

            public void setStopxh(String stopxh) {
                this.stopxh = stopxh;
            }
        }
    }
}
