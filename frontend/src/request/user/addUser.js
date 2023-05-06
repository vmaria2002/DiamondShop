import React from "react";
import axios from "axios";

const addUser = async (user) => {
    await axios.post("http://localhost:8080/api/users/adduser", user);
    return user;
  };

export default addUser;
