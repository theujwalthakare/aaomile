// src/main/resources/static/js/create-event.js
document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('eventForm');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const eventTitle = document.getElementById('eventTitle').value;
        const eventLocation = document.getElementById('eventLocation').value;
        const eventPrice = document.getElementById('eventPrice').value;
        const eventVenue = document.getElementById('eventVenue').value;
        const eventDate = document.getElementById('eventDate').value;
        const eventImage = document.getElementById('eventImage').files[0];
        
        const formData = new FormData();
        formData.append('title', eventTitle);
        formData.append('location', eventLocation);
        formData.append('price', eventPrice);
        formData.append('venue', eventVenue);
        formData.append('date', eventDate);
        formData.append('image', eventImage);


        // Send the form data to the server to handle image upload
        fetch('/upload-image', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            const eventData = {
                title: eventTitle,
                location: eventLocation,
                price: eventPrice,
                venue: eventVenue,
                date: eventDate,
                imageUrl: data.imageUrl // Use the image URL returned from the server
            };

        // Store event data in local storage
        let events = JSON.parse(localStorage.getItem('events')) || [];
        events.push(eventData);
        localStorage.setItem('events', JSON.stringify(events));

        // Redirect back to the home page
        window.location.href = '/'; // Assuming the home page is at the root
    })
     .catch(error => {
        console.error('Error uploading image:', error);
     });
   });
});