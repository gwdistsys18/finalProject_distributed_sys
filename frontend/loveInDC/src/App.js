import React, { Component } from 'react';
import { BrowserRouter, HashRouter, Route, Switch, Link } from 'react-router-dom';

import Index from './views/Index';
import Login from './views/Login';
import Register from './views/Register';
import Account from './views/Account';

class App extends Component {
  render() {
    return (
      <HashRouter>
        <div>
          <div className="main-wrapper">
            <Route path="/" exact component={Index}></Route>
            <Route path="/login" exact component={Login}></Route>
            <Route path="/signup" exact component={Register}></Route>
            <Route path="/account" exact component={Account}></Route>
          </div>
        </div>
      </HashRouter>
    )
  }
}

export default App;
