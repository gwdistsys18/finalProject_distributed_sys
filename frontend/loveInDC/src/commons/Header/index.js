import React, { Component } from 'react';
import PropTypes from 'prop-types';

import './index.scss';

class Header extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    let username = localStorage.getItem("username");
    return (
      <header>
        <a className="brand" href="/#"/>
        <div className="menu">
          <a href="/#" className="center">Center</a>
          <a href="/#" className="community">Community</a>
          <a href="/#" className="activity">Activity</a>
        </div>
        <div className="user">
          {
            username == undefined ? 
              <p>Please <a href="/#/login">Login</a></p>
              :
              <p>Welcome, <a href="/#/account">{username}</a></p>
          }
        </div>
      </header>
    )
  }
}

export default Header;
