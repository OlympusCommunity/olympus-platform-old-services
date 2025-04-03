import axios from 'axios';
import { User } from '../types/User';

const API_URL = 'https://yourapi.com';

export const login = async (user: User) => {
  const response = await axios.post(`${API_URL}/login`, user);
  return response.data;
};

export const users = async () => {
  const endPoint = 'https://rickandmortyapi.com/api/character'
  const response = await axios.get(endPoint);
  return response.data;
}
