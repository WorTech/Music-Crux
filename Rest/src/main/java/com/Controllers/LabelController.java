package com.Controllers;

import com.Services.LabelService;
import com.db.mongo.models.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    LabelService labelService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Label getLabel(@PathVariable("id") String id) {
        return labelService.getLabel(id);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name", "limit"})
    public Collection<Label> getLabelsByName(@RequestParam("name") String name, @RequestParam("limit") int limit) {
        return labelService.getLabelsByName(name, limit);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Label> getLabelsByLocation(@RequestParam("location") String location, @RequestParam("limit") int limit) {
        return labelService.getLabelsByLocation(location, limit);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Label add(@RequestBody Label label) {
        return labelService.add(label);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Label update(@PathVariable("id") String id, @RequestBody Label label) {
        return null;
    }
}
