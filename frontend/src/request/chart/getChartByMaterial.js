  import React from "react";
  import axios from "axios";
   const getChartByMaterial = async (type, material, id) => {
    const result = await axios.get(`http://localhost:8080/api/chart/${type}/${material}/${id}`);
    setUser(result.data);
  };
  export default getChartByMaterial;
