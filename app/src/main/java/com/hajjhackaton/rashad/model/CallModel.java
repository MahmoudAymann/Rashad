package com.hajjhackaton.rashad.model;

public class CallModel {

    /**
     * status : {"type":1,"message":"Message Sent Successfully"}
     * data : {"calleeId":3,"userId":"5555","operationNo":5}
     */

    private StatusBean status;
    private DataBean data;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class StatusBean {
        /**
         * type : 1
         * message : Message Sent Successfully
         */

        private int type;
        private String message;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class DataBean {
        /**
         * calleeId : 3
         * userId : 5555
         * operationNo : 5
         */

        private int calleeId;
        private String userId;
        private int operationNo;

        public int getCalleeId() {
            return calleeId;
        }

        public void setCalleeId(int calleeId) {
            this.calleeId = calleeId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getOperationNo() {
            return operationNo;
        }

        public void setOperationNo(int operationNo) {
            this.operationNo = operationNo;
        }
    }
}
