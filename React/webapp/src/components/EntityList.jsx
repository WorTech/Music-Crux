import React from "react";
import Molecule from './Molecule';
import Card from "material-ui/Card";
import FlatButton from "material-ui/FlatButton";
import axios from "axios";
import Redirect from 'react-router-dom';

//This component may want an onClick function for each element
//When onClick is called, the molecule is generated for that clicked element
//May want to use the 'Card' component from material-ui
export default class EntityList extends React.Component {
  constructor(props) {
    super(props);
    this.handleGetMolecule = this.handleGetMolecule.bind(this);
  }

  componentWillReceieveProps() {}

  handleGetMolecule(entityID) {
    const self = this;
    axios
      .get("http://localhost:8080/api/molecule?focus=" + entityID)
      .then(function(response) {
        console.log(response.data);
        self.setState({ moleculeJSON: response.data });
      })
      .catch(function(err) {
        console.log(err);
      });
    console.log("Clicked on entity: " + entityID);
    
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
              <FlatButton
                label="Build molecule"
                primary={true}
                onClick={() => this.handleGetMolecule(entity.id)}
              />
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
