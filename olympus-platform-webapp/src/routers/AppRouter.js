import React from "react";
import { BrowserRouter, Route } from "react-router-dom";
import Routers from "react-dom";
import { LoginScreen } from "../components/session/LoginScreen";
import { JoinUsScreen } from "../components/session/JoinUsScreen";
import { DashboardRoute } from "./DashboardRoute";

export default function AppRouter() {
  return (
    <BrowserRouter>
      <div>
        <Routers>
          <Route path="/login" element={<LoginScreen />} />
          <Route path="/join-us" element={<JoinUsScreen />} />
          <Route path="/" element={<DashboardRoute />} />
        </Routers>
      </div>
    </BrowserRouter>
  );
}
