import axios from "axios";

const API_URL = "http://localhost:8080/api/seats";

//呼叫後端api專用
export const getAllSeats = () => axios.get(`${API_URL}/all`);
export const getAvailableSeats = () => axios.get(`${API_URL}/available`);
export const assignSeat = (empId, seatId) =>
  axios.post(`${API_URL}/assign?empId=${empId}&seatId=${seatId}`);