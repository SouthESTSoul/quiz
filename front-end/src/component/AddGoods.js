import React, {Component} from 'react';
import {createProduct} from './Common'
import Products from './Products'

class AddGoods extends Component {

  state={
    goods:{},
    canBeClicked:false
  }

  get goodsValid() {
	const { goodsName, price, unit, jpgUrl } = this.state.goods;
	return goodsName && price && unit && jpgUrl;
  }

  onFormFieldChange = (event) => {
	const { name, value } = event.target;
	const { goods } = this.state;
	this.setState({
	  goods: {
		...goods,
		[name]: value,
	  },
	});
  };

  onFormSubmit = (event) => {
	// event.preventDefault();
	const { goodsName, price, unit, jpgUrl } = this.state.goods;
	const goods = {goodsName, price, unit, jpgUrl};
	createProduct(goods).then(()=>alert('创建成功') ).catch((error)=>alert(`创建失败,${error.message}`))
  };

  render() {
	const { onFormFieldChange, onFormSubmit, goodsValid } = this;
	return (
		<form action="/">
		  <label htmlFor="goodsName" className="required">
			名称：
		  </label>
		  <input
			  type="text"
			  id="goodsName"
			  placeholder="名称"
			  name="goodsName"
			  onChange={onFormFieldChange}
		  />

		  <label htmlFor="price" className="required">
			价格：
		  </label>
		  <input
			  type="number"
			  min="0"
			  step="1"
			  id="price"
			  placeholder="价格"
			  name="price"
			  onChange={onFormFieldChange}
		  />

		  <label htmlFor="unit" className="required">
			单位：
		  </label>
		  <input
			  type="text"
			  id="unit"
			  placeholder="单位"
			  name="unit"
			  onChange={onFormFieldChange}
		  />

		  <label htmlFor="image" className="required">
			图片：
		  </label>
		  <input
			  type="text"
			  id="jpgUrl"
			  placeholder="URL"
			  name="jpgUrl"
			  onChange={onFormFieldChange}
		  />

		  <button
			  className="add-product-submit-btn"
			  onClick={onFormSubmit}
			  disabled={!goodsValid}
		  >
			提交
		  </button>
		</form>
	);
  }
}

export default AddGoods;