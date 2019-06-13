package com.hopedc.learn.stream.normal;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RequestMethod {
    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String desc;

    /**
     * 参数数量
     */
    private Integer argsNum;


    public static final class RequestMethodBuilder {
        private String name;
        private String desc;
        private Integer argsNum;

        public RequestMethodBuilder() {
        }

        public static RequestMethodBuilder aRequestMethod() {
            return new RequestMethodBuilder();
        }

        public RequestMethodBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RequestMethodBuilder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public RequestMethodBuilder argsNum(Integer argsNum) {
            this.argsNum = argsNum;
            return this;
        }

        public RequestMethod build() {
            RequestMethod requestMethod = new RequestMethod();
            requestMethod.setName(name);
            requestMethod.setDesc(desc);
            requestMethod.setArgsNum(argsNum);
            return requestMethod;
        }
    }
}
