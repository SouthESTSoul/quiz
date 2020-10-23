
const baseRequestSetting = {
  mode: "cors",
};

export async function httpPost(url, body) {
  return await fetch(url, {
	...baseRequestSetting,
	body: JSON.stringify(body),
	headers: {
	  "content-type": "application/json",
	},
	method: "POST",
  });
}

export async function createProduct(product) {
  const response = await httpPost("http://localhost:8080/goods", product);

  if (response.status !== 201) {
	const data = await response.json();
	throw new Error(data.message);
  }

  return;
}