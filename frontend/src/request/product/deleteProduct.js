import React from "react";
import axios from "axios";

const deleteProduct = async (id) => {
    await axios.delete(`http://localhost:8080/api/produs/delete/${id}`, user);
 export default deleteProduct;
