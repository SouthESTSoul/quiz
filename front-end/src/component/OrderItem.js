import React, { Component } from 'react';

class OrderItem extends Component {
  render() {
	return (
		<div className="order-item">
		  <div className="description">
			<h1>{this.props.goodsName}</h1>
			<p>单价:{this.props.price}元/{this.props.unit}</p>
			<p>{this.props.count}</p>
		  </div>
		  <button>删除</button>
		</div>
	);
  }
}

export  default  OrderItem