"use strict";

console.log("Script loaded"); // 

function toggleTheme() {
  var body = document.body;
  var currentTheme = body.getAttribute('data-bs-theme');
  var newTheme = currentTheme === 'light' ? 'dark' : 'light'; // Update the theme

  body.setAttribute('data-bs-theme', newTheme); // Save the user's preference to localStorage

  localStorage.setItem('theme', newTheme); // Toggle icons

  document.getElementById('dark-icon').style.display = newTheme === 'light' ? 'inline' : 'none';
  document.getElementById('light-icon').style.display = newTheme === 'dark' ? 'inline' : 'none';
} // Load the saved theme on page load


document.addEventListener('DOMContentLoaded', function () {
  var savedTheme = localStorage.getItem('theme') || 'light';
  document.body.setAttribute('data-bs-theme', savedTheme); // Set the correct icon

  document.getElementById('dark-icon').style.display = savedTheme === 'light' ? 'inline' : 'none';
  document.getElementById('light-icon').style.display = savedTheme === 'dark' ? 'inline' : 'none';
});
var events = [{
  title: "Jagjit Singh Memorial Singing Competition 2025",
  genre: "Music",
  date: "Jan 5 - Feb 8",
  price: 0,
  image: "https://via.placeholder.com/300x200"
}, {
  title: "Tum Zindagi Ban Gaye",
  genre: "Music",
  date: "On Demand",
  price: 199,
  image: "https://via.placeholder.com/300x200"
}, {
  title: "Char Bondhur Sondhe",
  genre: "Music",
  date: "On Demand",
  price: 299,
  image: "https://via.placeholder.com/300x200"
}, {
  title: "Yoga for Beginners",
  genre: "Health & Wellness",
  date: "July 8",
  price: 499,
  image: "https://via.placeholder.com/300x200"
}, {
  title: "Theatre Rehearsal: Tughlaq",
  genre: "Theatre",
  date: "July 15",
  price: 149,
  image: "https://via.placeholder.com/300x200"
}, {
  title: "Wine 101 by Gargi Kothari",
  genre: "Courses",
  date: "On Demand",
  price: 1500,
  image: "https://via.placeholder.com/300x200"
}, {
  title: "Contemporary Dance Workshop",
  genre: "Workshops",
  date: "July 20",
  price: 700,
  image: "https://via.placeholder.com/300x200"
}]; // Function to display events

function displayEvents(filteredEvents) {
  var eventsContainer = document.getElementById('eventsContainer');
  eventsContainer.innerHTML = '';
  filteredEvents.forEach(function (event) {
    var eventCard = "\n          <div class=\"col-md-4\">\n              <div class=\"card event-card\">\n                  <img src=\"".concat(event.image, "\" alt=\"").concat(event.title, "\">\n                  <div class=\"badge-category\">").concat(event.genre, "</div>\n                  <div class=\"event-info\">\n                      <h5>").concat(event.title, "</h5>\n                      <p><i class=\"bi bi-calendar-event\"></i> ").concat(event.date, "</p>\n                      <p>Price: \u20B9").concat(event.price === 0 ? 'Free' : event.price, "</p>\n                  </div>\n              </div>\n          </div>\n      ");
    eventsContainer.innerHTML += eventCard;
  });
} // Filter events by genre


function filterGenre(genre) {
  var filteredEvents = genre === 'All' ? events : events.filter(function (event) {
    return event.genre === genre;
  });
  displayEvents(filteredEvents);
  document.querySelectorAll('.filter-buttons button').forEach(function (btn) {
    return btn.classList.remove('active');
  });
  document.querySelector("button:contains(".concat(genre, ")")).classList.add('active');
} // Sort events by selected option


function sortEvents() {
  var sortValue = document.getElementById('sortDropdown').value;
  var sortedEvents;

  if (sortValue === 'PriceLow') {
    sortedEvents = [].concat(events).sort(function (a, b) {
      return a.price - b.price;
    });
  } else if (sortValue === 'PriceHigh') {
    sortedEvents = [].concat(events).sort(function (a, b) {
      return b.price - a.price;
    });
  } else {
    sortedEvents = events;
  }

  displayEvents(sortedEvents);
} // Display all events on page load


window.onload = function () {
  return displayEvents(events);
}; // Function to get URL parameters


function getUrlParameter(name) {
  name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
  var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
  var results = regex.exec(location.search);
  return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
} // Automatically filter events based on URL parameter


window.onload = function () {
  var genre = getUrlParameter('genre');

  if (genre) {
    filterGenre(genre.charAt(0).toUpperCase() + genre.slice(1)); // Capitalize first letter
  }
}; // after hiting create event submit button 


document.getElementById('eventForm').addEventListener('submit', function (event) {
  event.preventDefault();
  var newEvent = {
    title: document.getElementById('title').value,
    genre: document.getElementById('genre').value,
    date: document.getElementById('date').value,
    price: parseInt(document.getElementById('price').value),
    image: document.getElementById('image').value
  }; // Save the new event to localStorage or send it to a server

  var events = JSON.parse(localStorage.getItem('events')) || [];
  events.push(newEvent);
  localStorage.setItem('events', JSON.stringify(events)); // Redirect to the events page

  window.location.href = 'Events';
});

window.onload = function () {
  var genre = getUrlParameter('genre');

  if (genre) {
    filterGenre(genre.charAt(0).toUpperCase() + genre.slice(1)); // Capitalize first letter
  } else {
    displayEvents(events); // Display all events if no genre is specified
  }
};