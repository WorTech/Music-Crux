import React, { Component } from "react";
import AppBar from 'material-ui/AppBar';
import Search from "./components/Search";
import Molecule from "./components/Molecule";
import { Route, Switch, BrowserRouter } from "react-router-dom";
import { MuiThemeProvider } from "material-ui/styles";

class Main extends Component {
  render() {
    return (
      <div className="Main">
      <MuiThemeProvider>
        <AppBar title="MusicCrux" />
      </MuiThemeProvider>
        <BrowserRouter>
          {/* <h1>Welcome to MusicCrux!</h1> */}
          <Switch>
            <Route path="/search" component={Search} />
            <Route exact path="/molecule" component={Molecule} />
          </Switch>
        </BrowserRouter>
      </div>
    );
  }
}

export default Main;
