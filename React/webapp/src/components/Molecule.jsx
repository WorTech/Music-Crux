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
    // console.log(this.props.location.state.molecule.entities);
    // console.log(this.props.location.state.molecule.relationships);
  }

  render() {
    var nodes = this.props.location.state.molecule.entities.slice(0);
    var links = this.props.location.state.molecule.relationships;
    var focusEntity_id;
    console.log("Nodes: ");
    console.log(nodes);
    console.log("Relationships: ");
    console.log(links);
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
        <div style={{minHeight:"100%", minWidth:"100%"}}>
          <InteractiveForceGraph
            simulationOptions={{
               // height: "100%",
               // width: "100%",
              radiusMargin: 100,
              strength: {
                /* 
                    I think this property controls how far away
                    you want unconnected nodes to be from the molecule.
                  */
                charge: 50
              },
              animate: true
            }}
            labelAttr="label"
            showLabels
            onSelectNode={node => console.log(node)}
            highlightDependencies
            zoom
            
          >
            {/* Reverse the order of the array so our focus is at the beginning of the array */}
            {nodes.map(function(entity, index) {
              // This can totally be written a lot neater. . .
              var fill;
              //Make the focused-entity a different color
              if (index == 0) {
                focusEntity_id = entity.id;
                fill = "red";
              } 
              else if(entity.type == "ARTIST"){
                fill = "green"
              }
              else if(entity.type == "BAND"){
                fill = "blue"
              }

              return (
                <ForceGraphNode
                  node={{ id: entity.id, label: entity.name, radius: 10 }}
                  fill={fill}
                />
              );
            })}

            {/* <ForceGraphLink link={{source: 2, target: 0}} /> */}
            {links.map(function(relationship, index) {
              // console.log("Relationship index: " + index);
              // console.log(relationship);
              var source, target;
              if (entities.length > 0) {
                if (nodes[0].type == "BAND") {
                  source = relationship.entityA.id;
                  target = relationship.entityB.id;
                } else if (nodes[0].type == "ARTIST") {
                  source = relationship.entityB.id;
                  target = relationship.entityA.id;
                }
                // target = relationship.
                return (
                  <ForceGraphLink
                    link={{
                      source: source,
                      target: target,
                      /* 
                        The react-vis-force library is buggy and for some reason needs a value field
                        here to highlight dependencies.
                      */
                      value: 10
                    }}
                  />
                );
              }
            })}
          </InteractiveForceGraph>
          {/* {entities} */}
          {/* {relationships} */}
        </div>
      );
    } else return <h3>Need to query a focused entity first!</h3>;
  }
}
