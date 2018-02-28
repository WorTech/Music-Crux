import React from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AutoComplete from 'material-ui/AutoComplete';
import SelectField from 'material-ui/SelectField';
import axios from 'axios';
import { RaisedButton, MenuItem } from 'material-ui';


//Example of queried GET request with params
//http://localhost:8081/artist/?name=Alexi&limit=20

const artistURL = "http://localhost:8081/artist/?name=";

export default class Search extends React.Component {
    constructor(props){
        super(props);
        this.onUpdateInput = this.onUpdateInput.bind(this);
        this.getResults = this.getResults.bind(this);
        this.state = {
            dataSource: [],
            inputValue: '',
            value: 1,
            currentFilter: '',
        }
    }


    getResults(){
        var config = {
            headers: {
                'Content-Type':'application/json',
                'Access-Control-Allow-Origin':'*',
            }
        }

        var searchQueryParams = {
            params: {
                name:'Alexi',
                limit:10,
            }            
        }


        axios.get(artistURL, searchQueryParams).then(function(response){
            console.log(response);
        }).catch(function(err){
            console.log(err);
        })
    }

    onUpdateInput(inputValue) {
        const self = this;
        this.setState({
            inputValue: inputValue
        }, function(){
            self.performSearch();
        });
    }

    performSearch() {
        //Example of queried GET request with params
        //http://localhost:8081/artist/?name=Alexi&limit=20

        //PROPER ENDPOINT
        //http://localhost:8080/api/entity/?type=artist&name=James&limit=5.
        const URL = "http://localhost:8080/api/entity/"//artist    /?name=";

        const queryString = "?type=" + this.state.value + "&name="+this.state.inputValue+"&limit=10"

        const 
            self = this,
            url = URL + queryString;
        console.log(url);

        if(this.state.inputValue !== ''){
            axios.get(url).then(function(response){
                //console.log(response)
                let retrieval;
                retrieval = response.data.map(function(result){
                    //console.log("THIS IS A RESULT: " + result.name);
                    return result.name;
                });
                //console.log("This is retrieval: " + retrieval);
                self.setState({dataSource:retrieval})
            });
        }
    }

    handleChange = (event, index, value) => this.setState({value}, () => console.log(value));

 render(){
     return(
    <MuiThemeProvider>
         <div>
             <h1> This is the Search component! </h1>
             <div>
             <SelectField
                floatingLabelText="EntityType"
                defaultValue="Check"
                value={this.state.value}
                onChange={this.handleChange}
             >
                 <MenuItem value={"artist"} primaryText="Artist" />
                 <MenuItem value={"band"}   primaryText="Band" />
                 <MenuItem value={"label"}  primaryText="Label" />
                 <MenuItem value={"album"}  primaryText="Album" />
                 <MenuItem value={"track"}  primaryText="Track" />
             </SelectField>
             </div>
             <AutoComplete 
                hintText="(i.e. Search for an artist . . . )"
                dataSource = {this.state.dataSource}
                onUpdateInput = {this.onUpdateInput}
             />
            <RaisedButton 
                label="Search" 
                onClick={this.getResults}
            />
         </div>
    </MuiThemeProvider>
     )
 }   
}