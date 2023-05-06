import React from "react";
import axios from "axios";
  const deleteProductFromOrder = async (user, operatie) => {
   var URL="";
  if(operatie==="delete"){
        URL ="http://localhost:8080/api/command/command/delete/${user.id}";
   }else{
     URL ="/";
   }

   return await axios.get(URL);
  };
 export default deleteProductFromOrder;
