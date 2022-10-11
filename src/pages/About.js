import React from 'react';
import { Link } from 'react-router-dom';
import alexk from '../images/alexk.jpeg';

import Hero from '../components/Hero';
import Banner from '../components/Banner';

export default function About() {
  return (
    <>
      <Hero>
        <Banner title="About us">
          <Link to="/rooms" className="btn-primary">
            Our rooms
          </Link>
        </Banner>
      </Hero>
      <h2 className="about-title">Welcome to BU Hotel</h2>
      <div className="about-section">
        <div className="about-description">
          <p>
            We can have a section for each of us here
            <br />
            <br />
            <Link to="/">
              <img src={alexk} />
            </Link>
            Alex Kolbin is the cloud engineer... etc.
            <br />
            <br />
          </p>
        </div>
        <div className="hostel-services-list">
          <ul className="services-list">
            <li>Free Internet</li>
            <li>Prime Boston Location</li>
            <li>Daily Cleaning</li>
            <li>Pool</li>
            <li>Spa</li>
          </ul>
        </div>
      </div>
    </>
  );
}
