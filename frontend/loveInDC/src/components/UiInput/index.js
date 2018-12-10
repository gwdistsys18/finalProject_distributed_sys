import React, { Component } from 'react';
import PropTypes from 'prop-types';

import './index.scss';

class UiInput extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="ui-input">
        <input type={this.props.typeName} placeholder={this.props.name} 
          value={ this.props.value }
          onChange={e => this.props.handleChange(e.target.value)}/>
      </div>
    )
  }
}

UiInput.propTypes = {
  name: PropTypes.string,
  value: PropTypes.string,
  handleChange: PropTypes.func,
  typeName: PropTypes.string
}

UiInput.defaultProps = {    
  typeName: 'text'
}

export default UiInput;
