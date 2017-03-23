package com.example.administrator.ddbusdatatest.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class StateCode {


    /**
     * data : [{"stacode":"10464"},{"stacode":"10465"},{"stacode":"10466"},{"stacode":"10467"},{"stacode":"10468"},{"stacode":"10474"},{"stacode":"10478"}]
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
         * stacode : 10464
         */

        private String stacode;

        public String getStacode() {
            return stacode;
        }

        public void setStacode(String stacode) {
            this.stacode = stacode;
        }
    }
}
