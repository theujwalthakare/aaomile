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



function startLoading() {
  // Show loading message and hide the button
  document.getElementById('myButton').classList.add('hidden');
  document.getElementById('loader').classList.remove('hidden');
  
  // Simulate a delay (e.g., 3 seconds)
  setTimeout(function() {
    // After delay, show the redirecting message
    document.getElementById('loader').textContent = "Redirecting...";
    
    // Redirect after another 2 seconds
    setTimeout(function() {
      // Redirect to the next HTML page (change the URL to your target HTML file)
      window.open("/user/event/create","_blank");  // Replace with the actual file name or URL
    }, 1000); // 2-second delay before redirection
  }, 2000); // 3-second delay for loading
}

setTimeout(function() {
  const toast = document.getElementById('toast-success');
  if (toast) {
    toast.classList.add('opacity-0');
    toast.classList.remove('opacity-100');
    setTimeout(function() {
      toast.style.display = 'none';
    }, 500); // Wait for the transition to finish
  }
}, 1000);

// const dropdown = FlowbiteInstances.getInstance('Dropdown', 'dropdownTimepicker');
// const $saveTimeButton = document.getElementById('saveTimeButton');

// $saveTimeButton.addEventListener('click', function() {
//     // save time code and then hide the dropdown
//     dropdown.hide();
// });



document.addEventListener('DOMContentLoaded', function() {
  const hoursSelect = document.getElementById('hours');
  const minutesSelect = document.getElementById('minutes');
  const secondsSelect = document.getElementById('seconds');
  const selectedDuration = document.getElementById('selected-duration');

  // Populate hours (0-23)
  for (let i = 0; i <= 23; i++) {
      const option = document.createElement('option');
      option.value = i;
      option.text = i.toString().padStart(2, '0');
      hoursSelect.appendChild(option);
  }

  // Populate minutes and seconds (0-59)
  [minutesSelect, secondsSelect].forEach(select => {
      for (let i = 0; i <= 59; i++) {
          const option = document.createElement('option');
          option.value = i;
          option.text = i.toString().padStart(2, '0');
          select.appendChild(option);
      }
  });

  // Update duration display
  function updateDuration() {
      const hours = hoursSelect.value.padStart(2, '0');
      const minutes = minutesSelect.value.padStart(2, '0');
      const seconds = secondsSelect.value.padStart(2, '0');
      
      selectedDuration.textContent = `${hours || '00'}:${minutes || '00'}:${seconds || '00'}`;
  }

  // Add event listeners
  hoursSelect.addEventListener('change', updateDuration);
  minutesSelect.addEventListener('change', updateDuration);
  secondsSelect.addEventListener('change', updateDuration);

  // Get duration value as total seconds
  function getDurationInSeconds() {
      const hours = parseInt(hoursSelect.value) || 0;
      const minutes = parseInt(minutesSelect.value) || 0;
      const seconds = parseInt(secondsSelect.value) || 0;
      return (hours * 3600) + (minutes * 60) + seconds;
  }

  // Get formatted duration
  function getFormattedDuration() {
      return selectedDuration.textContent;
  }
});