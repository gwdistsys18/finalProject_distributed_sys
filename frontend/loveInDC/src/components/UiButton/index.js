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
      <button className={"ui-button " + buttonType} 
        type="submit" 
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
