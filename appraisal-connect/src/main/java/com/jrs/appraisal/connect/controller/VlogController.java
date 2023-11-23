package com.jrs.appraisal.connect.controller;

import com.jrs.appraisal.connect.model.Vlog;
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

    public VlogController(VlogService vlogService) {
        this.vlogService = vlogService;
    }

    @GetMapping("/byId/{id}")
    public List<Vlog> getVlogs(@PathVariable String id) {
        log.info("retrieve vlogs");
        return vlogService.getVlogsById(id);
    }

}
