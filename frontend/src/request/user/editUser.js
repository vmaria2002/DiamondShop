 import React from "react";
 import axios from "axios";

 const editUser = async (id, user) => {
    await axios.put(`http://localhost:8080/api/users/update/${id}`, user);
  };
export default editUser;
