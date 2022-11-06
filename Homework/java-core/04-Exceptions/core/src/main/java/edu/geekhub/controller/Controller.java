package edu.geekhub.controller;

import edu.geekhub.models.request.Request;
import edu.geekhub.models.request.Response;

public interface Controller {

    Response process(Request request);
}
