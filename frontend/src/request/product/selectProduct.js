import React from "react";
import axios from "axios";

const selectProduct = async (id) => {
    await axios.get(`http://localhost:8081/api/items/${id}`, user);
 export default selectProduct;
