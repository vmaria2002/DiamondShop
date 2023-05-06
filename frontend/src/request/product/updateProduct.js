import React from "react";
import axios from "axios";

const updateProduct = async (id) => {
    await axios.post(`http://localhost:8081/api/items/${id}`, user);
 export default updateProduct;
