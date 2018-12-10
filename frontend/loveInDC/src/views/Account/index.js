import React, { Component } from 'react';
import PropTypes from 'prop-types';

import './index.scss';

import AccountSetting from './subComponents/AccountSetting';
import ChangePassword from './subComponents/ChangePassword';
import Preferences from './subComponents/Preferences';

const menuList = [
  "Account Setting",
  "Change Password",
  "Preferences"
];

class Account extends Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedTab: menuList[2]
    };
  }

  switchTabs(item) {
    this.setState({
      selectedTab: item
    });
  }

  render() {
    const {selectedTab} = this.state;
    const leftSide = menuList.map((item, ind) => {
      return <li key={ind} 
                className={item == selectedTab ? "active" : ""}
                onClick={() => this.switchTabs(item)}>{item}</li>;
    });
    return (
      <div className="accounts-settings">
        <div className="left-side">
          <ul>
            {leftSide}
          </ul>
        </div>
        <div className="right-side">
          {selectedTab == "Account Setting" ? <AccountSetting title={"Account Setting"}/> : ""}
          {selectedTab == "Change Password" ? <ChangePassword title={"Change Password"}/> : ""}
          {selectedTab == "Preferences" ? <Preferences title={"Preferences"}/> : ""}
        </div>
      </div>
    )
  }
}

export default Account;
