import React from "react";
import axios from "axios";


const createChart = async (id, user, type) => {
    await axios.put(`http://localhost:8080/api/chart/${id}/${type}`, user);
 };
export default createChart;
