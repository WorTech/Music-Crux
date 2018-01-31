package com.Controllers;

import com.Services.RelationshipService;
import com.db.mongo.models.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/relationship")
public class RelationshipController {

    @Autowired
    RelationshipService relationshipService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Relationship getRelationship(@PathVariable("id") String id) {
        return relationshipService.getRelationship(id);

    }

    @RequestMapping(method = RequestMethod.GET, params = {"types", "limit"})
    public Collection<Relationship> getRelationshipsByTypes(@RequestParam("types") List<String> type, @RequestParam("limit") int limit) {

        return relationshipService.getRelationshipsByTypes(type, limit);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Relationship add(@RequestBody Relationship relationship) {
        return relationshipService.add(relationship);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Relationship update(@PathVariable("id") String id, @RequestBody Relationship relationship) {
        return relationshipService.update(id, relationship);
    }

}
