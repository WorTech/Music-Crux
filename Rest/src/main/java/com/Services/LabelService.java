package com.Services;

import com.db.mongo.models.Label;
import com.db.mongo.repositories.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {

    @Autowired
    LabelRepository labelRepository;

    /**
     * @param id id of the Label
     * @return The Label matching the id
     */
    public Label getLabel(String id) {
        return labelRepository.findOne(id);
    }

    /**
     * @param name  Search string
     * @param limit max number of labels to return
     * @return labels matching the @name
     */
    public List<Label> getLabelsByName(String name, int limit) {
        return labelRepository.findByNameContaining(name, new PageRequest(0, limit));
    }

    /**
     * @param location search string
     * @param limit    max number of labels to return
     * @return labels matching the @location
     */
    public List<Label> getLabelsByLocation(String location, int limit) {
        // TODO
        return null;
    }

    /**
     * @param label Label to add in the database
     * @return The Label that was added
     */
    public Label add(Label label) {
        return labelRepository.save(label);
    }

    /**
     * @param id id of the Label
     * @return The Label that was updated
     */
    public Label update(String id, Label labelUpdates) {
        Label label = this.getLabel(id);
        label = labelUpdates;
        return label;
    }
}
