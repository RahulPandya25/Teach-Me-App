package com.teach.me.app.ServiceImpl;

import com.teach.me.app.Model.Response;
import com.teach.me.app.Repository.ResponseRepository;
import com.teach.me.app.Service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;
    /**
     * @param response
     */
    @Override
    public void insertResponse(Response response) {
        responseRepository.save(response);
    }

    /**
     * @return
     */
    @Override
    public List<Response> getAllResponses() {
        return responseRepository.findAll();
    }

    /**
     * @param responseId
     * @return
     */
    @Override
    public Optional<Response> getResponseById(int responseId) {
        return responseRepository.findById(responseId);
    }
}
