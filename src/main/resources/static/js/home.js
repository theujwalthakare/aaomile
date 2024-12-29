// src/main/resources/static/js/home.js
document.addEventListener('DOMContentLoaded', function() {
    const scrollContainer = document.getElementById('scroll-content');

    // Function to create a new card element
    function createCard(eventData, index) {
        const cardContainer = document.createElement('div');
        cardContainer.className = 'col-12 col-md-3 card-container';

        const card = document.createElement('div');
        card.className = 'card';

        const cardImgTop = document.createElement('img');
        cardImgTop.className = 'card-img-top';
        cardImgTop.src = eventData.imageUrl || 'images/placeholder.png'; // Use the image URL or placeholder
        cardImgTop.alt = 'Event image';

        const cardBody = document.createElement('div');
        cardBody.className = 'card-body';

        const cardTitle = document.createElement('h5');
        cardTitle.className = 'card-title';
        cardTitle.textContent = eventData.title;

        const cardLocation = document.createElement('p');
        cardLocation.className = 'card-text';
        cardLocation.textContent = eventData.location;

        const cardPrice = document.createElement('p');
        cardPrice.className = 'card-text text-success';
        cardPrice.textContent = eventData.price;

        const cardVenue = document.createElement('p');
        cardVenue.className = 'card-text';
        cardVenue.innerHTML = `<i class="fas fa-map-marker-alt"></i> ${eventData.venue}`;

        const cardDate = document.createElement('p');
        cardDate.className = 'card-text';
        cardDate.innerHTML = `<i class="far fa-calendar-alt"></i> ${eventData.date}`;

        const cardButton = document.createElement('a');
        cardButton.className = 'btn btn-primary';
        cardButton.href = '#';
        cardButton.textContent = 'Book it';

        const deleteButton = document.createElement('button');
        deleteButton.className = 'btn btn-danger mt-2';
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', function() {
            deleteEvent(index);
        });

        cardBody.appendChild(cardTitle);
        cardBody.appendChild(cardLocation);
        cardBody.appendChild(cardPrice);
        cardBody.appendChild(cardVenue);
        cardBody.appendChild(cardDate);
        cardBody.appendChild(cardButton);
        cardBody.appendChild(deleteButton);

        card.appendChild(cardImgTop);
        card.appendChild(cardBody);

        cardContainer.appendChild(card);

        return cardContainer;
    }

    // Load events from local storage and create cards
    function loadEvents() {
        const events = JSON.parse(localStorage.getItem('events')) || [];
        events.forEach((eventData, index) => {
            const card = createCard(eventData, index);
            scrollContainer.appendChild(card);
        });
    }

    // Delete an event from local storage and the DOM
    function deleteEvent(index) {
        let events = JSON.parse(localStorage.getItem('events')) || [];
        events.splice(index, 1);
        localStorage.setItem('events', JSON.stringify(events));

        // Clear the scroll container and reload events
        scrollContainer.innerHTML = '';
        loadEvents();
    }

    // Initial load of events
    loadEvents();

    // Button to navigate to create event page
    const btnExplore = document.getElementById('btn-explore');
    btnExplore.addEventListener('click', function() {
        window.location.href = 'create-event'; // Redirect to create event page
    });
});