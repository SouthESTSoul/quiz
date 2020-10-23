import React, {Component} from 'react';
import ProductItem from './ProductItem'
import OrderItem from './OrderItem'

class Orders extends Component {

  constructor() {
	super();
	this.state = {
	  orders: [],
	  isExist:true
	};
  }


  componentDidMount() {
	fetch('http://localhost:8080/orders')
		.then((response) => {
		  if (response.status === 200) {
			return response.json();
		  } else {
			Promise.reject(response.status);
		  }
		})
		.then((data) => {
		  this.setState({
			orders:data,
		  });
		})
		.catch((err) => {
		  console.log(err);
		  this.setState(
			  {
				isExist:false
			  }
		  )
		});
  }

  render() {
	return (
	<div className='orders'>
	  {this.state.orders.map((order,index)=>{
		return (<OrderItem count={order.count} price={order.goods.price} goodsName={order.goods.goodsName}  unit={order.goods.unit} key={index} ></OrderItem>
		);
	  })}
	</div>
	);
  }
}

export default Orders