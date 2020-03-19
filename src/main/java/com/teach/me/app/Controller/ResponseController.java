package com.teach.me.app.Controller;

import com.teach.me.app.Model.Response;
import com.teach.me.app.Model.User;
import com.teach.me.app.Service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/response")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @PostMapping("/insert")
    private void insertResponse(@RequestBody Response response){
        responseService.insertResponse(response);
    }

    @GetMapping("/all")
    private List<Response> getAllResponses(){
        List<Response> responseList = new ArrayList<Response>();
        responseList = responseService.getAllResponses();
        return  responseList;
    }

    @GetMapping("/{id}")
    private Optional<Response> getResponseById(@PathVariable int responseId){
        return responseService.getResponseById(responseId);
    }
}
