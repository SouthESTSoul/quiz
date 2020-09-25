import React, {Component} from 'react';
import ProductItem from './ProductItem'


class Products extends Component {

  constructor() {
	super();
	this.state = {
	  goodses: [],
	};
  }
  componentDidMount() {
	fetch('http://localhost:8080/goodses')
		.then((response) => {
		  if (response.status === 200) {
			return response.json();
		  } else {
			Promise.reject(response.status);
		  }
		})
		.then((data) => {
		  this.setState({
			goodses:data,
		  });
		})
		.catch((err) => {
		  console.log(err);
		});
  }


  render() {
	return (
		<div className="products">
		  {this.state.goodses.map((product,index)=>{
		    return (<ProductItem name={product.goodsName} price={product.price} img={product.jpgUrl} unit={product.unit} key={index} ></ProductItem>
			);
			  })}
		</div>
	);
  }
}

export default Products;
