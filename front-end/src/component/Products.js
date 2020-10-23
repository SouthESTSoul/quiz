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

  render(){
    let productItems;
    if(this.state.goodses.length===0){
	  productItems=(<p>暂无订单，返回商城页面继续购买</p>)
	}else{
	  productItems=  this.state.goodses.map((product,index)=>{
		return (<ProductItem name={product.goodsName} price={product.price} img={product.jpgUrl} unit={product.unit} key={index} ></ProductItem>
		);
	  })
	}
    return  <div className="products">
	  {productItems}
	</div>
  }

  // render() {
	// return (
	// 	<div className="products">
	// 	  {
	// 	    }
	// 	</div>
	// );
  // }
}

export default Products;
