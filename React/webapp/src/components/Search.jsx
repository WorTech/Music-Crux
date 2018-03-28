import React from "react";
import MuiThemeProvider from "material-ui/styles/MuiThemeProvider";
import AutoComplete from "material-ui/AutoComplete";
import Card from "material-ui/Card";
import SelectField from "material-ui/SelectField";
import axios from "axios";
import { RaisedButton, MenuItem } from "material-ui";

import EntityList from './EntityList';

const artistURL = "http://localhost:8081/artist/?name=";
const URL = "http://localhost:8080/api/entity/";

export default class Search extends React.Component {
  constructor(props) {
    super(props);
    this.onUpdateInput = this.onUpdateInput.bind(this);
    this.getResults = this.getResults.bind(this);
    this.state = {
      dataSource: [],
      inputValue: "",
      value: 1,
      entitySearch: null,
      cardStyle: {
        width:"50%",
        justifyContainer:"center",
      }
    };
  }

  getResults() {
    const self = this;
    const queryString =
      "?type=" +
      this.state.value +
      "&name=" +
      this.state.inputValue +
      "&limit=10";

    // var config = {
    //     headers: {
    //         'Content-Type':'application/json',
    //         'Access-Control-Allow-Origin':'*',
    //     }
    // }

    var newURL = URL + queryString;

    axios
      .get(newURL)
      .then(function(response) {
        self.setState({
          entitySearch: response.data
        });
        console.log(response);
      })
      .catch(function(err) {
        console.log(err);
      });
  }

  onUpdateInput(inputValue) {
    const self = this;
    this.setState(
      {
        inputValue: inputValue
      },
      function() {
        self.performSearch();
      }
    );
  }

  performSearch() {
    //Example of queried GET request with params
    //http://localhost:8081/artist/?name=Alexi&limit=20

    //PROPER ENDPOINT
    //http://localhost:8080/api/entity/?type=artist&name=James&limit=5.

    const queryString =
      "?type=" +
      this.state.value +
      "&name=" +
      this.state.inputValue +
      "&limit=100";

    const self = this,
      url = URL + queryString;
    //console.log(url);

    if (this.state.inputValue !== "") {
      axios.get(url).then(function(response) {
        //console.log(response)
        let retrieval;
        retrieval = response.data.map(function(result) {
          //console.log("THIS IS A RESULT: " + result.name);
          return result.name;
        });
        //console.log("This is retrieval: " + retrieval);
        self.setState({ dataSource: retrieval });
      });
    }
  }

  handleChange = (event, index, value) => this.setState({ value });

  render() {
    return (
      <MuiThemeProvider>
        <div style={{display:"flex", justifyContent:"center", marginTop:"10%"}}>
          <Card style={this.state.cardStyle}>
            <h1> Welcome to MusicCrux! </h1>
          <div>
            <SelectField
              floatingLabelText="EntityType"
              defaultValue="Check"
              value={this.state.value}
              onChange={this.handleChange}
            >
              <MenuItem value={"artist"} primaryText="Artist" />
              <MenuItem value={"band"} primaryText="Band" />
              <MenuItem value={"label"} primaryText="Label" />
              <MenuItem value={"album"} primaryText="Album" />
              <MenuItem value={"track"} primaryText="Track" />
            </SelectField>
          </div>
          <AutoComplete
            style={{paddingRight:"50px"}}
            hintText="(i.e. Search for an artist . . . )"
            dataSource={this.state.dataSource}
            onUpdateInput={this.onUpdateInput}
            onNewRequest={this.getResults}
          />
          <RaisedButton label="Search" onClick={this.getResults}/>
          </Card>
          </div>

          <div>
            {/* Display the queried entities. */}
            {/* <p>{this.state.entitySearch}</p> */}
            <EntityList entities={this.state.entitySearch}/>
          </div>
      </MuiThemeProvider>
    );
  }
}
