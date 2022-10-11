import React, { Component } from 'react';
import { FaMoneyCheck, FaSmile, FaShuttleVan, FaWifi } from 'react-icons/fa';

import Title from './Title';

export default class Services extends Component {
  state = {
    services: [
      {
        icon: <FaMoneyCheck />,
        title: 'Payment by card',
        info:
          'We accept payment from Visa and Mastercard.',
      },
      {
        icon: <FaSmile />,
        title: 'Kind people',
        info:
          'Our highest priority is to make sure your stay is as relaxing as possible. Our 24x7 staff are there to ensure you have everything you need.',
      },
      {
        icon: <FaShuttleVan />,
        title: 'Free shuttle',
        info:
          'Enjoy our complimentary free shuttle to nearby attractions.',
      },
      {
        icon: <FaWifi />,
        title: 'Free internet connection',
        info:
          'Every room comes with free, secure high-speed internet access.',
      },
    ],
  };

  render() {
    return (
      <section className="services">
        <Title title="Services" />
        <div className="services-center">
          {this.state.services.map((item, index) => {
            return (
              <article key={index} className="service">
                <span>{item.icon}</span>
                <h6>{item.title}</h6>
                <p>{item.info}</p>
              </article>
            );
          })}
        </div>
      </section>
    );
  }
}
