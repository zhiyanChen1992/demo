package com.example.administrator.ddbusdatatest.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/22 0022.
 */
public class StaionNamicInfo implements Serializable {

    /**
     * data : [{"routeDynamicinfo":[{"buslabel":"Test","dir":"1","routecode":"00008","stopcounts":"3"},{"buslabel":"","dir":"1","routecode":"00012","stopcounts":"n"},{"buslabel":"Test,Test","dir":"0","routecode":"0003A","stopcounts":"0"},{"buslabel":"","dir":"0","routecode":"0005X","stopcounts":"n"},{"buslabel":"Test","dir":"0","routecode":"0010A","stopcounts":"4"},{"buslabel":"Test","dir":"1","routecode":"00MT5","stopcounts":"3"}],"stacode":"10464"},{"routeDynamicinfo":[{"buslabel":"Test,Test,Test,Test","dir":"0","routecode":"0001A","stopcounts":"8"},{"buslabel":"Test,Test,Test","dir":"0","routecode":"00023","stopcounts":"2"},{"buslabel":"","dir":"0","routecode":"000N2","stopcounts":"n"},{"buslabel":"","dir":"1","routecode":"00N1A","stopcounts":"n"}],"stacode":"10465"},{"routeDynamicinfo":[{"buslabel":"Test","dir":"1","routecode":"00008","stopcounts":"4"},{"buslabel":"","dir":"1","routecode":"00012","stopcounts":"n"},{"buslabel":"Test,Test,Test,Test,Test","dir":"0","routecode":"00023","stopcounts":"2"},{"buslabel":"Test,Test","dir":"0","routecode":"0003A","stopcounts":"1"},{"buslabel":"","dir":"1","routecode":"0005X","stopcounts":"n"},{"buslabel":"Test","dir":"0","routecode":"0010A","stopcounts":"5"},{"buslabel":"Test","dir":"1","routecode":"00MT5","stopcounts":"4"}],"stacode":"10466"},{"routeDynamicinfo":[{"buslabel":"Test,Test,Test,Test","dir":"0","routecode":"0001A","stopcounts":"9"}],"stacode":"10467"},{"routeDynamicinfo":[{"buslabel":"Test,Test,Test,Test,Test","dir":"0","routecode":"00017","stopcounts":"x"},{"buslabel":"Test,Test,Test,Test","dir":"0","routecode":"0001A","stopcounts":"7"},{"buslabel":"Test,Test,Test","dir":"1","routecode":"00023","stopcounts":"x"},{"buslabel":"Test,Test,Test","dir":"1","routecode":"0010A","stopcounts":"6"},{"buslabel":"","dir":"1","routecode":"00N1A","stopcounts":"n"}],"stacode":"10468"},{"routeDynamicinfo":[{"buslabel":"Test,Test,Test,Test,Test","dir":"0","routecode":"00017","stopcounts":"2"},{"buslabel":"Test,Test,Test","dir":"1","routecode":"0010A","stopcounts":"7"}],"stacode":"10474"},{"routeDynamicinfo":[{"buslabel":"Test,Test,Test,Test","dir":"0","routecode":"00008","stopcounts":"9"},{"buslabel":"Test,Test,Test,Test,Test,Test","dir":"0","routecode":"00012","stopcounts":"0"},{"buslabel":"Test,Test,Test,Test,Test","dir":"0","routecode":"00023","stopcounts":"x"},{"buslabel":"Test,Test,Test","dir":"1","routecode":"0003A","stopcounts":"1"},{"buslabel":"Test","dir":"1","routecode":"00MT5","stopcounts":"2"}],"stacode":"10478"}]
     * header : {"status":"000"}
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
         * routeDynamicinfo : [{"buslabel":"Test","dir":"1","routecode":"00008","stopcounts":"3"},{"buslabel":"","dir":"1","routecode":"00012","stopcounts":"n"},{"buslabel":"Test,Test","dir":"0","routecode":"0003A","stopcounts":"0"},{"buslabel":"","dir":"0","routecode":"0005X","stopcounts":"n"},{"buslabel":"Test","dir":"0","routecode":"0010A","stopcounts":"4"},{"buslabel":"Test","dir":"1","routecode":"00MT5","stopcounts":"3"}]
         * stacode : 10464
         */

        private String stacode;
        private List<RouteDynamicinfoBean> routeDynamicinfo;

        public String getStacode() {
            return stacode;
        }

        public void setStacode(String stacode) {
            this.stacode = stacode;
        }

        public List<RouteDynamicinfoBean> getRouteDynamicinfo() {
            return routeDynamicinfo;
        }

        public void setRouteDynamicinfo(List<RouteDynamicinfoBean> routeDynamicinfo) {
            this.routeDynamicinfo = routeDynamicinfo;
        }

        public static class RouteDynamicinfoBean {
            /**
             * buslabel : Test
             * dir : 1
             * routecode : 00008
             * stopcounts : 3
             */

            private String buslabel;
            private String dir;
            private String routecode;
            private String stopcounts;

            public String getBuslabel() {
                return buslabel;
            }

            public void setBuslabel(String buslabel) {
                this.buslabel = buslabel;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getRoutecode() {
                return routecode;
            }

            public void setRoutecode(String routecode) {
                this.routecode = routecode;
            }

            public String getStopcounts() {
                return stopcounts;
            }

            public void setStopcounts(String stopcounts) {
                this.stopcounts = stopcounts;
            }
        }
    }
}
