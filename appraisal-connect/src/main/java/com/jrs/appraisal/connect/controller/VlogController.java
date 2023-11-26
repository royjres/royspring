package com.jrs.appraisal.connect.controller;

import com.jrs.appraisal.connect.model.User;
import com.jrs.appraisal.connect.model.Vlog;
import com.jrs.appraisal.connect.service.UserService;
import com.jrs.appraisal.connect.service.VlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vlog")
@CrossOrigin(origins = "http://localhost:4200")
public class VlogController {

    private final VlogService vlogService;

    private final UserService userService;

    public VlogController(VlogService vlogService, UserService userService) {
        this.vlogService = vlogService;
        this.userService = userService;
    }

    @GetMapping("/byId/{id}")
    public List<Vlog> getVlogs(@PathVariable String id) {
        log.info("retrieve vlogs");
        //log.info(vlogService.getVlogsById(id).get(0).getUser().getUserFirstName().toString());
     //   vlogService.getVlogsById(id).forEach(vlog -> {
     //       log.info(vlog.getUser().getUserFirstName().toString());
     //   });
     //   return vlogService.getVlogsById(id);


        List<Vlog> myVlogList = vlogService.getVlogsById(id);


        return myVlogList;
    }

}
