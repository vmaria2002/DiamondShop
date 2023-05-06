import React from "react";
import axios from "axios";

 const reportJSON = async () => {
     const result = await axios.get(`http://localhost:8080/api/raport/json/${id}`);
     setUser(result.data);
  };
export default reportJSON;
