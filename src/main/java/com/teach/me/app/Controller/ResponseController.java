package com.teach.me.app.Controller;

import com.teach.me.app.Enum.Option;
import com.teach.me.app.Exception.ResponseNotFoundException;
import com.teach.me.app.Model.Response;
import com.teach.me.app.Model.User;
import com.teach.me.app.Repository.ResponseRepository;
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

    @Autowired
    private ResponseRepository responseRepository;

    @PostMapping("/insert")
    private void insertResponse(@RequestBody Response response){
        responseService.insertResponse(response);
    }

    @GetMapping("/submitResponse/{userId}/{questId}/{answer}")
    private void submitResponse(@PathVariable String userId, @PathVariable String questId, @PathVariable String answer) throws ResponseNotFoundException {
        responseService.submitResponse(Integer.parseInt(userId), Integer.parseInt(questId), answer);
    }

    @GetMapping("/all")
    private List<Response> getAllResponses(){
        List<Response> responseList = new ArrayList<Response>();
        responseList = responseService.getAllResponses();
        return  responseList;
    }

    @GetMapping("/{id}")
    private Response getResponseById(@PathVariable int responseId) throws ResponseNotFoundException {
        return responseService.getResponseById(responseId);
    }

    @GetMapping("/{userId}/{testId}")
    private List<Response> getResponseByTestIdAndUserId(@PathVariable int userId, @PathVariable int testId){
        List<Response> responseList = new ArrayList<Response>();
        System.out.println("UserId: " + userId + " TestId: " + testId);
        responseList = responseService.getReponseByTestIdAndUserId(testId, userId);
        for(Response response : responseList){
            System.out.println(response);
        }
        return  responseList;
    }
}
