import React, {Component} from 'react';

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
	  <p>{this.state.orders}</p>
	</div>
	);
  }
}

export default Orders