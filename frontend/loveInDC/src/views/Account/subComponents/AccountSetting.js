import React, { Component } from 'react';
import PropTypes from 'prop-types';

import UiFormGroup from '../../../components/UiFormGroup';
import UiButton from '../../../components/UiButton';

class AccountSetting extends Component {
  constructor(props) {
    super(props);
    this.state = {
      birthDate: "",
      collage: "",
      email: "",
      firstName: "",
      gender: "",
      infoCompleteness: "",
      lastName: "",
      major: "",
      nickName: "",
      phoneNumber: ""
    };
  }

  render() {
    let {title} = this.props;
    return (
      <div className="setting-info">
        <h3>{title}</h3>
        <form>
          <UiFormGroup name="NickName" />
          <UiFormGroup name="Phone No." />
          <UiFormGroup name="College" />
          <UiFormGroup name="DOB" />
          <UiFormGroup name="Email" />
          <UiFormGroup name="FirstName" />
          <UiFormGroup name="LastName" />
          <UiFormGroup name="gender" />
          <UiFormGroup name="Major" />
          <UiButton buttonName="Save" buttonType={"ui-button--primary"}/>
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
