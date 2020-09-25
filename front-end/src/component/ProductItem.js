import React, { Component } from 'react';

class ProductItem extends Component {
  render() {
	return (
		<div className="product">
		  <img className='product_img' src={this.props.img} alt={this.props.name} height="200" width="200"  />
		  <div className="description">
			<h1>{this.props.name}</h1>
			<p>单价:{this.props.price}元/{this.props.unit}</p>
		  </div>
		  <button>+</button>
		</div>
	);
  }
}

export  default  ProductItem