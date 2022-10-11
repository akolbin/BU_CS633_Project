import React from 'react';

import MapSection from '../components/Map';
import ContactForm from '../components/ContactForm';

const location = {
  address: 'Boston, MA',
  lat: 42.3505,
  lng: 71.1054,
};

export default function Contacts() {
  return (
    <div>
      <div className="contact-section">
        <div className="contact-info">
          <div>
            <i className="fas fa-map-marker-alt"></i>Boston, MA 02215
          </div>
          <div>
            <i className="fas fa-envelope"></i>hotel@bu.edu
          </div>
          <div>
            <i className="fas fa-phone"></i>+00 0000 000 000
          </div>
          <div>
            <i className="fas fa-clock"></i>Mon - Fri 9:00am - 10:00pm
          </div>
        </div>
        <ContactForm />
      </div>
      <MapSection location={location} zoomLevel={17} /> {/* include it here */}
    </div>
  );
}
