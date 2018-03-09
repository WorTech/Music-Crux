import React from "react";
import ReactDOM from "react-dom";
import MuiThemeProvider from "material-ui/styles/MuiThemeProvider";
import darkBaseTheme from "material-ui/styles/baseThemes/darkBaseTheme";

import "./index.css";
import Main from "./Main";
import registerServiceWorker from "./registerServiceWorker";

const App = () => (
  <MuiThemeProvider muiTheme={darkBaseTheme}>
      <App />
  </MuiThemeProvider>
);

ReactDOM.render(<Main />, document.getElementById("root"));
registerServiceWorker();
