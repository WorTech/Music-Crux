import React from "react";
import {
  InteractiveForceGraph,
  ForceGraphNode,
  ForceGraphLink
} from "react-vis-force";

export default class Molecule extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  componentWillMount() {
    // console.log(this.props.location.state);
    console.log(this.props.location.state.molecule.entities);
    console.log(this.props.location.state.molecule.relationships);
  }

  render() {
    var nodes = this.props.location.state.molecule.entities;
    var links = this.props.location.state.molecule.relationships;
    var focusEntity_id;
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
          <InteractiveForceGraph
            simulationOptions={
              { 
                height: 1000,
                width: 1000, 
                radiusMargin: 20,
                strength: {
                  /* 
                    I think this property controls how far away
                    you want unconnected nodes to be from the molecule.
                  */
                  charge: -500
                } 
              }}
            labelAttr="label"
            onSelectNode={node => console.log(node)}
            highlightDependencies
            zoom
          >
            {/* <ForceGraphNode
              node={{ id: "first-node", label: "First node" }}
              fill="red"
            />
            <ForceGraphNode
              node={{ id: "second-node", label: "Second node" }}
              fill="blue"
            /> */}

            {/* Reverse the order of the array so our focus is at the beginning of the array */}
            {nodes.slice(0).reverse().map(function(entity, index){
              // This can totally be written a lot neater. . .
              // console.log("Entity index: " + index);
              // console.log(entity);
              var fill;
              //Make the focus-entity a different color
              if(index == 0) {
                focusEntity_id = entity.id;
                fill = "red"
              }
              else{
                fill = "blue"
              }
              return <ForceGraphNode node={{id:entity.id, label:entity.name, radius: 10}} fill={fill} />
            })}

            {/* <ForceGraphLink link={{source: 2, target: 0}} /> */}
            
            {links.map(function(relationship, index){
              // console.log("Relationship index: " + index);
              // console.log(relationship);
              return <ForceGraphLink link={{source:relationship.entityB.id, target: focusEntity_id}} />
            })} 
           

            {/* <ForceGraphLink
              link={{ source: "first-node", target: "second-node" }}
            /> */}
          </InteractiveForceGraph>
          {/* {entities} */}
          {/* {relationships} */}
        </div>
      );
    } else return <h3>Need to query a focused entity first!</h3>;
  }
}
