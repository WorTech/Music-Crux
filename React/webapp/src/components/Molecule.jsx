import React from "react";

export default class Molecule extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    if (this.props.molecule) {
      return (
        <div>
          <h1> Molecule Component </h1>
        </div>
      );
    }
    else
        return null;
  }
}
