import React from "react";
// import Molecule from "./Molecule";
import Card from "material-ui/Card";
import FlatButton from "material-ui/FlatButton";
import axios from "axios";
// import { Link } from "react-router-dom";
import createHistory from "history/createBrowserHistory";

//This component may want an onClick function for each element
//When onClick is called, the molecule is generated for that clicked element
//May want to use the 'Card' component from material-ui

const history = createHistory({
  forceRefresh: true
});

export default class EntityList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
    this.handleGetMolecule = this.handleGetMolecule.bind(this);
    this.handleMoleculeJSON = this.handleMoleculeJSON.bind(this);
  }

  componentWillReceieveProps() {}

  handleGetMolecule(entityID, entityType) {
    const self = this;
    axios
      .get("http://localhost:8080/api/molecule?focus=" + entityID + "&type=" + entityType + "&depth=5")
      .then(function(response) {
        console.log(response.data);
        self.setState({ moleculeJSON: response.data }, () => {
          console.log(self.state.moleculeJSON.entities);
          console.log(self.state.moleculeJSON.relationships);
          //Redirect to the molecule component when user hits 'Build Molecule'
          history.push({
            pathname: "/molecule",
            state: { molecule: self.state.moleculeJSON }
          });
        });
      })
      .catch(function(err) {
        console.log(err);
      });
    console.log("Clicked on entity: " + entityID);
  }

  handleMoleculeJSON() {
    const self = this;
    if (self.state.moleculeJSON) {
      return self.state.moleculeJSON;
    } else {
      return null;
    }
  }

  render() {
    if (this.props.entities) {
      let entityResults = this.props.entities.map(entity => {
        return (
          <div>
            <Card>
              <h3>
                Id: {entity.id} Name: {entity.name}
              </h3>
              {/* <Link to="/molecule" params={{test:"ok"}} */}
              <FlatButton
                label="Build molecule"
                primary={true}
                onClick={() => this.handleGetMolecule(entity.id, entity.type)}
              />
              {/* </Link> */}
            </Card>
          </div>
        );
      });
      return (
        <div>
          {entityResults}

          {/* <Molecule molecule={this.state.moleculeJSON} /> */}
        </div>
      );
    } else {
      return null;
    }
  }
}
