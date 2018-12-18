import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { message } from 'antd';
import { DatePicker } from 'antd';
import moment from 'moment';
import { Switch, Icon } from 'antd';

import UiFormGroup from '../../../components/UiFormGroup';
import UiButton from '../../../components/UiButton';

import { getUserInfo, updateUserInfo } from '../../../request/userInfo';

const save = () => {
  const hide = message.loading('Save in progress..', 0);
  // Dismiss manually and asynchronously
  setTimeout(hide, 100);
}

class AccountSetting extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userData: {
        firstName: "",
        lastName: "",
        birthDate: "",
        college: "",
        major: "",
        gender: "",
        nickName: "",
        phoneNumber: ""
      }
    };
  }

  componentWillMount() {
    getUserInfo(({data}) => {
      console.log(data);
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
    let { birthDate, gender } = this.state.userData;
    return (
      <div className="setting-info">
        <h3>{title}</h3>
        <form>
          {
            Object.keys(this.state.userData).map((item, ind) => {
              if(item == 'gender') {
                return (
                  <div className="form-group" key={ind}>
                    <label>{item.toUpperCase()}</label>
                    <Switch checkedChildren="M" unCheckedChildren="F" defaultChecked={gender == "M"} 
                      onChange={(value) => this.handleChange(item, value ? "M" : "F")}/>
                  </div>
                );
              } else if (item == 'birthDate') {
                return (
                  <div className="form-group" key={ind}>
                    <label>{item.toUpperCase()}</label>
                    <DatePicker value={moment(birthDate, 'YYYY-MM-DD')} 
                      onChange={(value, string) => this.handleChange(item, string)}/>
                  </div>
                );
              } else {
                return (
                  <UiFormGroup key={ind} 
                    name={item.toUpperCase()}
                    value={this.state.userData[item] === null ? "" : this.state.userData[item]}
                    handleChange={(v) => this.handleChange(item, v)}/>
                );
              }
            })
          }
          <UiButton buttonName="Save" buttonType={"ui-button--primary"} clickEvent={() => {
            save();
            this.updateUserInfo();
          }}/>
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
