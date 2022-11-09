import React, { Component } from 'react';

import logo from '../images/hotel-dummy.png';
import { FaAlignRight } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import user from '../images/avatar-generic.png';
import settings from '../images/settings.png';
import room from '../images/room.png';
import logout from '../images/logout.png';

export default class Navbar extends Component {
  state = {
    isOpen: false,
  };

  handleToggle = () => {
    this.setState({ isOpen: !this.state.isOpen });
  };

  toggleMenu = () => {
    let subMenu = document.getElementById("subMenu");
    subMenu.classList.toggle("open-menu");
  }

  render() {
    return (
      <nav className="navbar">
        <div className="nav-center">
          <div className="nav-header">
            <Link to="/">
              <img src={logo} alt="BU Hotel" />
            </Link>
            <button
              type="button"
              className="nav-btn"
              onClick={this.handleToggle}
            >
              <FaAlignRight className="nav-icon" />
            </button>
          </div>
          <ul
            className={this.state.isOpen ? 'nav-links show-nav' : 'nav-links'}>
            <li>
              <Link to="/home">Home</Link>
            </li>
            <li>
              <Link to="/rooms">Rooms</Link>
            </li>
            <li>
              <Link to="/contacts">Contacts</Link>
            </li>
            <li>
              <Link to="/about">About us</Link>
            </li>
          </ul>
          <img src={user} class="user-pic" onClick={this.toggleMenu}></img>
          <div class="sub-menu-wrap" id="subMenu">
            <div class="sub-menu">
              <div class="user-info">
                <img src={user}></img>
                <h3>
                  John Doe
                </h3>
              </div>
              <hr></hr>
              <a href="#" class="sub-menu-link">
                <img src={user}></img>
                <p>Edit Profile</p>
                <span>{'>'}</span>
              </a>
              <a href="#" class="sub-menu-link">
                <img src={settings}></img>
                <p>Settings & Privacy</p>
                <span>{'>'}</span>
              </a>
              <a href="#" class="sub-menu-link">
                <img src={room}></img>
                <p>Bookings</p>
                <span>{'>'}</span>
              </a>
              <a href="/login" class="sub-menu-link">
                <img src={logout}></img>
                <p>Logout</p>
                <span>{'>'}</span>
              </a>
            </div>
          </div>
        </div>
      </nav>
    );
  }
}
