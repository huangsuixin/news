package com.app.huangsuixin1506101066.bean;

import java.util.List;

/**
 * @author Silence
 */

public class ResponseBean {
    private Integer showapi_res_code;
    private String showapi_res_error;
    private ResBody showapi_res_body;

    public ResponseBean() {
        showapi_res_body = new ResBody();
    }

    public Integer getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(Integer showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ResBody getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ResBody showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "showapi_res_code=" + showapi_res_code +
                ", showapi_res_error='" + showapi_res_error + '\'' +
                ", showapi_res_body=" + showapi_res_body +
                '}';
    }

    public class ResBody {
        private Integer ret_code;
        private NewsPager pagebean;

        public ResBody() {
            pagebean = new NewsPager();
        }

        public Integer getRet_code() {
            return ret_code;
        }

        public void setRet_code(Integer ret_code) {
            this.ret_code = ret_code;
        }

        public NewsPager getPagebean() {
            return pagebean;
        }

        public void setPagebean(List<NewsPager> pagebean) {
            this.pagebean = (NewsPager) pagebean;
        }

        @Override
        public String toString() {
            return "ResBody{" +
                    "showapi_res_code=" + ret_code +
                    ", pagebean=" + pagebean +
                    '}';
        }
    }
}

