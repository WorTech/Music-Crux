import React from "react";

export default class Molecule extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  componentWillMount() {
    console.log(this.props.location.state);
    console.log(this.props.location.state.molecule.entities);
    console.log(this.props.location.state.molecule.relationships);
  }

  render() {
    if (this.props.location.state) {
      //Print entities
      let entities = this.props.location.state.molecule.entities.map(entity => {
        return (
          <div>
            <p>
              id: {entity.id} type: {entity.type} name: {entity.name}
            </p>
          </div>
        );
      });

      //Print relationships
      let relationships = this.props.location.state.molecule.relationships.map(
        relationship => {
          return (
            <div>
              <p>
                RelationshipType: {relationship.type} EntityB Name:{" "}
                {relationship.entityB.name}
              </p>
            </div>
          );
        }
      );

      return (
        <div>
          {entities}
          {relationships}
        </div>
      );
    } else return <h3>Need to query a focused entity first!</h3>;
  }
}