import React, { Component } from 'react';
import PropTypes from 'prop-types';

import './index.scss';

class UiRadio extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    let {title, dict} = this.props;
    return (
      <div className="radio-group" onChange={(e) => this.props.handleChange(e.target.value)}>
        <p className="title">{title}</p>
        {
          Object.keys(dict).map((item, ind) => (
            <label className="radio" key={ind}>
              <input name={title} value={dict[item]} type="radio" defaultChecked={dict[item] == this.props.check}/>
              <span className="radio-label">{item}</span>
            </label>
          ))
        }
      </div>
    )
  }
}

UiRadio.propTypes = {
  dict: PropTypes.object,
  title: PropTypes.string,
  check: PropTypes.bool,
  handleChange: PropTypes.func
}

export default UiRadio;
