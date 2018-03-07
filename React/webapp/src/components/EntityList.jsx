import React from "react";


//This component may want an onClick function for each element
//When onClick is called, the molecule is generated for that clicked element
//May want to use the 'Card' component from material-ui
export default class EntityList extends React.Component {
  constructor(props) {
    super(props);
  }

  componentWillReceieveProps(){

  }

  render() {
    if (this.props.entities) {
      let entityResults = this.props.entities.map(entity => {
        return( 
            <div>
                <h3>Id: {entity.id} Name: {entity.name}</h3> 
            </div>
            )
      });
      return <div>{entityResults}</div>;
    }

    else{
        return <div><h1>No results to display.</h1></div>
    }
  }
}
