import React from "react";
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";
import { AboutUsScreen } from "../components/about/AboutUsScreen";
import { CommunityScreen } from "../components/community/CommunityScreen";
import { ContactScreen } from "../components/contact/ContactScreen";
import { Navbar } from "../components/entends/Navbar";
import { Footer } from "../components/entends/Footer";
import { GaleryScreen } from "../components/galery/GaleryScreen";
import { MembersScreen } from "../components/members/MembersScreen";
import { OlympusScreen } from "../components/olympus/OlympusScreen";

export const DashboardRoute = () => {
  return (
    <React.Fragment>
      <Navbar />
      <div>
        <BrowserRouter>
          <Routes>
            <Route path="/welcome/*" element={<OlympusScreen />} />
            <Route path="/members/*" element={<MembersScreen />} />
            <Route epath="/about-us/*" element={<AboutUsScreen />} />
            <Route path="/contact/*" element={<ContactScreen />} />
            <Route path="/galery/*" element={<GaleryScreen />} />
            <Route path="/community/*" element={<CommunityScreen />} />
            <Navigate to="/welcome/*" />
          </Routes>
        </BrowserRouter>
      </div>
      <Footer />
    </React.Fragment>
  );
};
