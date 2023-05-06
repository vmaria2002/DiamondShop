  import React from "react";
  import axios from "axios";
  const getChartByType = async (field, id) => {
    const result = await axios.get(`http://localhost:8080/api/chart/${field}/${id}`);
    setUser(result.data);
  };
  export default getChartByType;
