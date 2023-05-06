
import axios from "axios";

const getAllUsers = async () => {
     await axios.get("http://localhost:8080/api/users/allusers");
 };

export default getAllUsers;