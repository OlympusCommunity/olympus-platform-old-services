import React, { useState } from 'react';
import { login } from '../../services/api';
import { User } from '../../types/User';
import { validateEmail, validatePassword } from '../../utils/validation';

const LoginForm: React.FC = () => {
  const [user, setUser] = useState<User>({ username: '', password: '', email: '' });
  const [error, setError] = useState<string>('');

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setUser({
      ...user,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!validateEmail(user.email)) {
      setError('Invalid email format');
      return;
    }
    if (!validatePassword(user.password)) {
      setError('Password must be at least 6 characters');
      return;
    }
    try {
      const response = await login(user);
      console.log('Login successful:', response);
    } catch (error) {
      console.error('Login failed:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Username:</label>
        <input type="text" name="username" value={user.username} onChange={handleChange} />
      </div>
      <div>
        <label>Password:</label>
        <input type="password" name="password" value={user.password} onChange={handleChange} />
      </div>
      <div>
        <label>Email:</label>
        <input type="email" name="email" value={user.email} onChange={handleChange} />
      </div>
      {error && <p>{error}</p>}
      <button type="submit">Login</button>
    </form>
  );
};

export default LoginForm;
