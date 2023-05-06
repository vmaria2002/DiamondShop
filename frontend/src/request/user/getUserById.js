import React from "react";
import axios from "axios";
const getuserById = async (id) => {
    const result = await axios.get(`http://localhost:8080/api/users/getuser/${id}`);
    setUser(result.data);
  };
export default getuserById;
