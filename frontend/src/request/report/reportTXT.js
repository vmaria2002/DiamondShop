import React from "react";
import axios from "axios";
  const reportTXT = async () => {
   return await axios.get(`http://localhost:8080/api/raport/txt/${id}`);
  };
 export default reportTXT;
