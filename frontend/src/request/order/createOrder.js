import React from "react";
import axios from "axios";
  const createOrder = async (user, operatie) => {
   var URL="";
   if operatie==="create" {
        URL ="http://localhost:8080/api/command/get/${user.id}";
   }else{
     URL ="/";
   }

   return await axios.get(URL);
  };
 export default createOrder;
