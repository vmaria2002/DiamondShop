import React from "react";
import axios from "axios";

const getChartBySize = async (type, size, id) => {
    const result = await axios.get(`http://localhost:8080/api/chart/${type}/${size}/${id}`);
    setUser(result.data);
  };
export default getChartBySize;
