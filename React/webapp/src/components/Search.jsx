import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AutoComplete from 'material-ui/AutoComplete';
import JSONP from 'jsonp';
import axios from 'axios';
import { RaisedButton } from 'material-ui';


//Example of queried GET request with params
//http://localhost:8081/artist/?name=Alexi&limit=20

const artistURL = "http://localhost:8081/artist/?name=";
const allArtistsURL = "http://localhost:8081/artists"

export default class Search extends React.Component {
    constructor(props){
        super(props);
        this.onUpdateInput = this.onUpdateInput.bind(this);
        this.getResults = this.getResults.bind(this);
        this.state = {
            dataSource: [],
            inputValue: '',
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
        
        const 
            self = this,
            url = artistURL + this.state.inputValue + "&limit=10";
        console.log(url);
        if(this.state.inputValue !== ''){
            axios.get(url).then(function(response){
                console.log(response)
                let retrieval;
                retrieval = response.data.map(function(result){
                    //console.log("THIS IS A RESULT: " + result.name);
                    return result.name;
                });
                console.log("This is retrieval: " + retrieval);
                self.setState({dataSource:retrieval})
            });
        }
    }

 render(){
     return(
    <MuiThemeProvider>
         <div>
             <h1> This is the Search component! </h1>
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