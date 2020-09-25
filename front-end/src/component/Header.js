import React, {Component} from 'react';
import {Link} from 'react-router-dom';
class Header extends Component {
  render() {
	return (
		<div className="header">
			<Link to='/' >商城</Link>
			<Link to='/calculator'>订单</Link>
			<Link to='/timer'>+ 添加商品</Link>
		</div>
	);
  }
}

export default Header;
