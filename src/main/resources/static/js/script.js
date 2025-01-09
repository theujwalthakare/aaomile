console.log("Script loaded");

let currentTheme = getTheme();
//initial -->

document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

//TODO:
function changeTheme() {
  //set to web page

  changePageTheme(currentTheme, "");
  //set the listener to change theme button
  const changeThemeButton = document.querySelector("#theme_change_button");

  changeThemeButton.addEventListener("click", (event) => {
    let oldTheme = currentTheme;
    console.log("change theme button clicked");
    if (currentTheme === "dark") {
      //theme ko light
      currentTheme = "light";
    } else {
      //theme ko dark
      currentTheme = "dark";
    }
    console.log(currentTheme);
    changePageTheme(currentTheme, oldTheme);
  });
}

//set theme to localstorage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

//get theme from localstorage
function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}

//change current page theme
function changePageTheme(theme, oldTheme) {
  //localstorage mein update karenge
  setTheme(currentTheme);
  //remove the current theme

  if (oldTheme) {
    document.querySelector("html").classList.remove(oldTheme);
  }
  //set the current theme
  document.querySelector("html").classList.add(theme);

  // change the text of button
  document
    .querySelector("#theme_change_button")
    .querySelector("#Light").textContent = theme == "light" ? "" : "";
}

const events =[
  {
    "id": 1,
    "name": "Virtual Stand-Up Comedy Night",
    "genre": "Comedy",
    "price": "₹499",
    "time": "2025-01-10 8:00 PM",
    "location": "Online",
    "image": "/images/event/comedy1.jpg"
  },
  {
    "id": 2,
    "name": "Learn Guitar in 30 Days",
    "genre": "Music",
    "price": "₹999",
    "time": "2025-01-12 6:00 PM",
    "location": "Online",
    "image": "/images/event/guitar-course.jpg"
  },
  {
    "id": 3,
    "name": "Yoga for Beginners",
    "genre": "Health & Wellness",
    "price": "Free",
    "time": "2025-01-14 7:00 AM",
    "location": "Online",
    "image": "/images/event/people-practicing-yoga-outside.jpg"
  },
  {
    "id": 4,
    "name": "Photography Basics Workshop",
    "genre": "Workshops",
    "price": "₹799",
    "time": "2025-01-15 4:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 5,
    "name": "Virtual Cooking Class - Indian Cuisine",
    "genre": "Pocket Friendly",
    "price": "₹299",
    "time": "2025-01-16 5:30 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 6,
    "name": "Theatre Appreciation Webinar",
    "genre": "Theater and Arts",
    "price": "₹499",
    "time": "2025-01-18 3:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 7,
    "name": "Creative Writing Workshop",
    "genre": "Courses",
    "price": "₹899",
    "time": "2025-01-20 11:00 AM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 8,
    "name": "Virtual Painting Class",
    "genre": "Workshops",
    "price": "₹599",
    "time": "2025-01-22 2:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 9,
    "name": "Digital Marketing Crash Course",
    "genre": "Courses",
    "price": "₹1499",
    "time": "2025-01-25 10:00 AM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 10,
    "name": "Meditation for Stress Relief",
    "genre": "Health & Wellness",
    "price": "Free",
    "time": "2025-01-26 6:30 AM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 11,
    "name": "Jazz Night - Live Virtual Performance",
    "genre": "Music",
    "price": "₹699",
    "time": "2025-01-28 8:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 12,
    "name": "Stand-Up Special: Laugh Therapy",
    "genre": "Comedy",
    "price": "₹399",
    "time": "2025-01-29 9:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 13,
    "name": "Salsa Dancing Basics",
    "genre": "Workshops",
    "price": "₹499",
    "time": "2025-02-01 5:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 14,
    "name": "Virtual Fitness Bootcamp",
    "genre": "Health & Wellness",
    "price": "₹599",
    "time": "2025-02-02 7:00 AM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 15,
    "name": "Introduction to Screenwriting",
    "genre": "Courses",
    "price": "₹1299",
    "time": "2025-02-03 2:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 16,
    "name": "Art Therapy for Beginners",
    "genre": "Health & Wellness",
    "price": "Free",
    "time": "2025-02-05 4:30 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 17,
    "name": "Shakespearean Drama Masterclass",
    "genre": "Theater and Arts",
    "price": "₹999",
    "time": "2025-02-06 11:00 AM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 18,
    "name": "Vegan Cooking Workshop",
    "genre": "Pocket Friendly",
    "price": "₹349",
    "time": "2025-02-08 6:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 19,
    "name": "Introduction to Mobile App Development",
    "genre": "Courses",
    "price": "₹1599",
    "time": "2025-02-09 10:00 AM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 20,
    "name": "Virtual Open Mic Poetry Night",
    "genre": "Theater and Arts",
    "price": "₹199",
    "time": "2025-02-10 8:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 21,
    "name": "Digital Art Workshop",
    "genre": "Workshops",
    "price": "₹899",
    "time": "2025-02-11 3:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 22,
    "name": "Bollywood Dance Fitness",
    "genre": "Health & Wellness",
    "price": "₹499",
    "time": "2025-02-13 7:00 AM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 23,
    "name": "Crafting Stories for Social Media",
    "genre": "Courses",
    "price": "₹999",
    "time": "2025-02-14 5:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 24,
    "name": "Virtual Zumba Party",
    "genre": "Pocket Friendly",
    "price": "₹249",
    "time": "2025-02-15 6:30 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 25,
    "name": "Mastering Acrylic Painting",
    "genre": "Theater and Arts",
    "price": "₹699",
    "time": "2025-02-17 2:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 26,
    "name": "How to Monetize Your Blog",
    "genre": "Courses",
    "price": "₹1199",
    "time": "2025-02-18 12:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 27,
    "name": "Self-Care Sunday: Meditation & Yoga",
    "genre": "Health & Wellness",
    "price": "Free",
    "time": "2025-02-20 8:00 AM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 28,
    "name": "Live Music Concert: Indie Bands",
    "genre": "Music",
    "price": "₹899",
    "time": "2025-02-22 9:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 29,
    "name": "Creative Coding for Beginners",
    "genre": "Courses",
    "price": "₹1499",
    "time": "2025-02-24 3:00 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  },
  {
    "id": 30,
    "name": "Improv Theatre Workshop",
    "genre": "Theater and Arts",
    "price": "₹499",
    "time": "2025-02-25 5:30 PM",
    "location": "Online",
    "image": "https://via.placeholder.com/150"
  }
  // Add 40 more entries similar to these...
];



// Function to display events
function displayEvents(filteredEvents) {
  const eventsContainer = document.getElementById('eventsContainer');
  eventsContainer.innerHTML = ''; // Clear previous events

  filteredEvents.forEach(event => {
    const eventCard = `
        <div class="flex flex-wrap justify-center gap-4">
    <!-- Event Card Template -->
    <div class="event-card bg-white rounded-lg shadow-md overflow-hidden mb-4">
        <img src="${event.image}" alt="${event.name}" class="event-image w-full h-48 object-cover">
        <div class="event-details p-4">
            <h3 class="event-name text-xl font-bold text-gray-900">${event.name}</h3>
            <p class="event-price text-lg text-gray-700">${event.price}</p>
            <p class="event-time text-gray-600">${event.time}</p>
            <p class="event-location text-gray-600">${event.location}</p>
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

  // Set active class for selected filter
  document.querySelectorAll('.filter-buttons button').forEach(btn => btn.classList.remove('active'));
  const genreButton = [...document.querySelectorAll('.filter-buttons button')].find(button => button.textContent === genre);
  if (genreButton) {
    genreButton.classList.add('active');
  }
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

// Get URL parameters
function getUrlParameter(name) {
  const urlParams = new URLSearchParams(window.location.search);
  return urlParams.get(name);
}

// Automatically filter events based on URL parameter and display selected genre as heading
window.onload = function () {
  const genre = getUrlParameter('genre');
  if (genre) {
      // Capitalize first letter and filter events by genre
      filterGenre(genre.charAt(0).toUpperCase() + genre.slice(1));
      // Set the heading to show the selected genre
      document.getElementById('genre-heading').textContent = `Category: ${genre.charAt(0).toUpperCase() + genre.slice(1)}`;
  } else {
      // Display all events if no genre is specified
      displayEvents(events);
      document.getElementById('genre-heading').textContent = 'Category: All';
  }
};
