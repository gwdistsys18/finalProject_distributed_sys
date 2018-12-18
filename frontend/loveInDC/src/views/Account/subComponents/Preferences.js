import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { message } from 'antd';

import UiRadio from "../../../components/UiRadio";
import UiButton from "../../../components/UiButton";

import info from "../../../utils/store";
import { getUserInfoById, updateUserPreferenceById } from "../../../request/userPreference";

const save = () => {
  const hide = message.loading('Save in progress..', 0);
  // Dismiss manually and asynchronously
  setTimeout(hide, 100);
}

class Preferences extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: {
        sports: false,
        music: false,
        technology: false,
        politics: false,
        art: false,
        literature:false,
        game: false,
        movie: false,
        cooking: false,
        finance: false
      },
      userId: localStorage.getItem('userId')
    };
  }

  componentWillMount() {
    console.log('willMount');
    getUserInfoById(this.state.userId, ({ data }) => {
      if (data.data['id'] !== undefined) {
        delete data.data['id'];
      }
      this.setState({
        data: data.data
      });
    }, () => {
      console.log('error');
    });
  }

  handleChange(item, v) {
    let data = this.state.data;
    data[item] = v === 'true' ? true : false;
    this.setState({data: data});
  }

  updatePreference(id) {
    updateUserPreferenceById(id, this.state.data, ({ data }) => {
      console.log(data);
    }, (err) => {
      console.log(err);
    });
  }

  render() {
    let {title} = this.props;
    let select = {
      yes: true,
      no: false
    };
    let radioList = Object.keys(this.state.data).map((item, ind) => (
      <UiRadio key={ind} title={item.toUpperCase()}
        check={this.state.data[item]}
        dict={select}
        handleChange={v => this.handleChange(item, v)}/>
    ));
    return (
      <div className="setting-info">
        <h3>{title}</h3>
        <form>
          {radioList}
          <UiButton buttonName="Save" buttonType={"ui-button--primary"} clickEvent={() => {
            save();
            this.updatePreference(this.state.userId);
          }}/>
        </form>
      </div>
    )
  }
}

Preferences.propTypes = {
  title: PropTypes.string
}

export default Preferences;
