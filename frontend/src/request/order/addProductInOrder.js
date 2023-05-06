import React from "react";
import axios from "axios";
  const addProductInOrder = async (user, operatie) => {
   var URL="";
   if operatie==="addProduct" {
        URL ="http://localhost:8080/api/command/get/${user.id}/${user.productid}"
   }else{
     URL ="/";
   }

   return await axios.get(URL);
  };
 export default addProductInOrder;
