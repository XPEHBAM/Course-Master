package com.coursemaster.service.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.coursemaster.database.DatabaseConnectionManager;
import com.coursemaster.service.AbstractService;

public class UpdateEvent extends AbstractService {

    @Override
    public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JSONObject data = new JSONObject(request.getParameter("data"));
            String id = data.getString("id");
            String name = data.getString("name");
            String descr = data.getString("descr");
            String course = data.getString("course");
            String start = data.getString("start");
            String end = data.getString("end");

            DatabaseConnectionManager.executeUpdate(String.format(
               "update event set " +
               "name   = '%s', " +
               "descr  = '%s', " +
               "start  = '%s', " +
               "end    = '%s', " +
               "course =  %s " +
               "where id   =  %s;",
            name, descr, start, end, course, id));
        } catch (JSONException e) { }
    }

}
