import React, { Component } from 'react';
import PropTypes from 'prop-types';

import './index.scss';

class UiButton extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    let {buttonType, disabled, buttonName, clickEvent} = this.props;
    return (
      <button type="button" 
        className={"ui-button " + buttonType}
        onClick={clickEvent}
        disabled={disabled}>
        { buttonName }
      </button>
    )
  }
}

UiButton.propTypes = {
  buttonName: PropTypes.string,
  buttonType: PropTypes.string,
  buttonDisabled: PropTypes.bool,
  clickEvent: PropTypes.func
}

UiButton.defaultProps = {    
  disabled: false
}

export default UiButton;
