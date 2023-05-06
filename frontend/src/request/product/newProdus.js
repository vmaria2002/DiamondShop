import React from "react";
import axios from "axios";

const newProdus = async (id) => {
    await axios.post(`http://localhost:8080/api/produs/newprodus/${id}`, user);
 export default newProdus;
