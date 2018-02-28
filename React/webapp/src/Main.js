import React, { Component } from 'react';
import Search from './components/Search';

class Main extends Component {
  render() {
    return (
      <div className="Main">
          <h1>Welcome to React!</h1>
          <Search />
      </div>
    );
  }
}

export default Main;
