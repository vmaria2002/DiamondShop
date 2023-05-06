import React from "react";
import axios from "axios";
  const finishOrder = async (user, operatie) => {
   var URL="";
   if operatie==="finish" {
        URL ="http://localhost:8080/api/command/plasareComanda/${user.id}"
   }else{
     URL ="/";
   }

   return await axios.get(URL);
  };
 export default finishOrder;
