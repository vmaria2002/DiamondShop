import React from "react";
import axios from "axios";

export default function deleteUserById(id) {
      return axios.delete(`http://localhost:8080/api/users/deleteuser/${id}`);
}
