import React, { Component } from 'react';
import PropTypes from 'prop-types';

import UiFormGroup from '../../../components/UiFormGroup';
import UiButton from '../../../components/UiButton';

import { getUserInfo, updateUserInfo } from '../../../request/userInfo';

class AccountSetting extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userData: {
        birthDate: "",
        college: "",
        email: "",
        firstName: "",
        gender: "",
        infoCompleteness: "",
        lastName: "",
        major: "",
        nickName: "",
        phoneNumber: ""
      }
    };
  }

  componentWillMount() {
    getUserInfo(({data}) => {
      console.log(data.data);
      this.setState({
        userData: {...data.data}
      });
    }, (err) => {
      console.log(err);
    });
  }

  handleChange(key, value) {
    let userData = this.state.userData;
    userData[key] = value;
    this.setState({
      userData: userData
    });
  }

  updateUserInfo() {
    updateUserInfo(this.state.userData, ({ data }) => {
      console.log(data);
    }, (err) => {
      console.log(err);
    });
  }

  render() {
    let {title} = this.props;
    return (
      <div className="setting-info">
        <h3>{title}</h3>
        <form>
          {
            Object.keys(this.state.userData).map((item, ind) => (
              <UiFormGroup key={ind} 
                name={item.toUpperCase()}
                value={this.state.userData[item] === null ? "" : this.state.userData[item]}
                handleChange={(v) => this.handleChange(item, v)}/>
            ))
          }
          <UiButton buttonName="Save" buttonType={"ui-button--primary"} clickEvent={() => this.updateUserInfo()}/>
        </form>
      </div>
    )
  }
}

AccountSetting.propTypes = {
  title: PropTypes.string,
  info: PropTypes.object
}

export default AccountSetting;
