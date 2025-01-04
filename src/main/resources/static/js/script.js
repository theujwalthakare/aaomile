console.log("Script loaded");

// 

function toggleTheme() {
  const body = document.body;
  const currentTheme = body.getAttribute('data-bs-theme');
  const newTheme = currentTheme === 'light' ? 'dark' : 'light';

  // Update the theme
  body.setAttribute('data-bs-theme', newTheme);

  // Save the user's preference to localStorage
  localStorage.setItem('theme', newTheme);

  // Toggle icons
  document.getElementById('dark-icon').style.display = newTheme === 'light' ? 'inline' : 'none';
  document.getElementById('light-icon').style.display = newTheme === 'dark' ? 'inline' : 'none';
}

// Load the saved theme on page load
document.addEventListener('DOMContentLoaded', () => {
  const savedTheme = localStorage.getItem('theme') || 'light';
  document.body.setAttribute('data-bs-theme', savedTheme);

  // Set the correct icon
  document.getElementById('dark-icon').style.display = savedTheme === 'light' ? 'inline' : 'none';
  document.getElementById('light-icon').style.display = savedTheme === 'dark' ? 'inline' : 'none';
});

const events = [
  { title: "Jagjit Singh Memorial Singing Competition 2025", genre: "Music", date: "Jan 5 - Feb 8", price: 0, image: "https://via.placeholder.com/300x200" },
  { title: "Tum Zindagi Ban Gaye", genre: "Music", date: "On Demand", price: 199, image: "https://via.placeholder.com/300x200" },
  { title: "Char Bondhur Sondhe", genre: "Music", date: "On Demand", price: 299, image: "https://via.placeholder.com/300x200" },
  { title: "Yoga for Beginners", genre: "Health & Wellness", date: "July 8", price: 499, image: "https://via.placeholder.com/300x200" },
  { title: "Theatre Rehearsal: Tughlaq", genre: "Theatre", date: "July 15", price: 149, image: "https://via.placeholder.com/300x200" },
  { title: "Wine 101 by Gargi Kothari", genre: "Courses", date: "On Demand", price: 1500, image: "https://via.placeholder.com/300x200" },
  { title: "Contemporary Dance Workshop", genre: "Workshops", date: "July 20", price: 700, image: "https://via.placeholder.com/300x200" }
];

// Function to display events
function displayEvents(filteredEvents) {
  const eventsContainer = document.getElementById('eventsContainer');
  eventsContainer.innerHTML = '';

  filteredEvents.forEach(event => {
      const eventCard = `
          <div class="col-md-4">
              <div class="card event-card">
                  <img src="${event.image}" alt="${event.title}">
                  <div class="badge-category">${event.genre}</div>
                  <div class="event-info">
                      <h5>${event.title}</h5>
                      <p><i class="bi bi-calendar-event"></i> ${event.date}</p>
                      <p>Price: ₹${event.price === 0 ? 'Free' : event.price}</p>
                  </div>
              </div>
          </div>
      `;
      eventsContainer.innerHTML += eventCard;
  });
}

// Filter events by genre
function filterGenre(genre) {
  const filteredEvents = genre === 'All' ? events : events.filter(event => event.genre === genre);
  displayEvents(filteredEvents);
  document.querySelectorAll('.filter-buttons button').forEach(btn => btn.classList.remove('active'));
  document.querySelector(`button:contains(${genre})`).classList.add('active');
}

// Sort events by selected option
function sortEvents() {
  const sortValue = document.getElementById('sortDropdown').value;
  let sortedEvents;

  if (sortValue === 'PriceLow') {
      sortedEvents = [...events].sort((a, b) => a.price - b.price);
  } else if (sortValue === 'PriceHigh') {
      sortedEvents = [...events].sort((a, b) => b.price - a.price);
  } else {
      sortedEvents = events;
  }

  displayEvents(sortedEvents);
}

// Display all events on page load
window.onload = () => displayEvents(events);

// Function to get URL parameters
function getUrlParameter(name) {
  name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
  const regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
  const results = regex.exec(location.search);
  return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
}

// Automatically filter events based on URL parameter
window.onload = function () {
  const genre = getUrlParameter('genre');
  if (genre) {
      filterGenre(genre.charAt(0).toUpperCase() + genre.slice(1)); // Capitalize first letter
  }
};



// after hiting create event submit button 
document.getElementById('eventForm').addEventListener('submit', function(event) {
  event.preventDefault();

  const newEvent = {
      title: document.getElementById('title').value,
      genre: document.getElementById('genre').value,
      date: document.getElementById('date').value,
      price: parseInt(document.getElementById('price').value),
      image: document.getElementById('image').value
  };

  // Save the new event to localStorage or send it to a server
  let events = JSON.parse(localStorage.getItem('events')) || [];
  events.push(newEvent);
  localStorage.setItem('events', JSON.stringify(events));

  // Redirect to the events page
  window.location.href = 'Events';
});

window.onload = function () {
  const genre = getUrlParameter('genre');
  if (genre) {
      filterGenre(genre.charAt(0).toUpperCase() + genre.slice(1)); // Capitalize first letter
  } else {
      displayEvents(events); // Display all events if no genre is specified
  }
};