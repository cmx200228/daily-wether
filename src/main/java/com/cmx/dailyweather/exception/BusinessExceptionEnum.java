package com.cmx.dailyweather.exception;

/**
 * @author 陈蒙欣
 * @date 2022/12/25 23:59
 */
public class BusinessExceptionEnum {

        private Integer code;

        private String message;

        public BusinessExceptionEnum(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
}
