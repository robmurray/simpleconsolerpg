package com.wmb.simplerpg;

/**
 * Created by rob on 7/7/15.
 */
public class ActionResponse {
    private String message;

    private boolean actionSuccess;

    public ActionResponse() {
    }

    public ActionResponse(boolean actionSuccess) {
        this.actionSuccess = actionSuccess;
    }

    public ActionResponse(String message) {
        this.message = message;
    }

    public ActionResponse(String message, boolean actionSuccess) {
        this.message = message;
        this.actionSuccess = actionSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isActionSuccess() {
        return actionSuccess;
    }

    public void setActionSuccess(boolean actionSuccess) {
        this.actionSuccess = actionSuccess;
    }
}
