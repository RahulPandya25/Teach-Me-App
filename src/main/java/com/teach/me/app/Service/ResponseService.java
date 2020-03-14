package com.teach.me.app.Service;

import com.teach.me.app.Model.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ResponseService {
    /**
     *
     * @param response
     */
    public void insertResponse(Response response);

    /**
     *
     * @return
     */
    public List<Response> getAllResponses();

    /**
     *
     * @param id
     * @return
     */
    public Optional<Response> getResponseById(int id);
}
