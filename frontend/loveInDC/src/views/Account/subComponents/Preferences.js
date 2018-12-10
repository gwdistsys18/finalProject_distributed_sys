import React, { Component } from 'react';
import PropTypes from 'prop-types';

import UiRadio from "../../../components/UiRadio";
import UiButton from "../../../components/UiButton";

class Preferences extends Component {
  constructor(props) {
    super(props);
    this.state = {
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
    };
  }

  change(key, value) {
    this.setState({
      key: value
    });
  }

  render() {
    let {title} = this.props;
    let select = {
      yes: true,
      no: false
    };
    let radioList = Object.keys(this.state).map((item, ind) => (
      <UiRadio key={ind} title={item.toUpperCase()}
        check={this.state[item]}
        dict={select}
        handleChange={v => this.setState({item: ind})}/>
    ));
    return (
      <div className="setting-info">
        <h3>{title}</h3>
        <form>
          {radioList}
          <UiButton buttonName="Save" buttonType={"ui-button--primary"}/>
        </form>
      </div>
    )
  }
}

Preferences.propTypes = {
  title: PropTypes.string
}

export default Preferences;
